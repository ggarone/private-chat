package com.rotechnology.chat.integration;

import com.rotechnology.chat.entity.Chat;
import com.rotechnology.chat.entity.ChatKey;
import com.rotechnology.chat.entity.User;
import com.rotechnology.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/chat")
@RequiredArgsConstructor
@Slf4j
public class ChatResource {
    private final ChatService chatService;

    @GetMapping("/all")
    public ResponseEntity<List<Chat>> getAllChats(){
        log.info("{getAllChats} : Getting all Chats");
        return  ResponseEntity.ok().body(chatService.getChats());
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Chat> getChatById(@RequestBody ChatKey ck){
        log.info("{getChatById} : Getting Chat of senderId {} receiverId {} messageId {}",
                ck.getSenderId(),ck.getReceiverId(),ck.getMessageId());
        return ResponseEntity.ok().body(chatService.findChatByCompositeKey(ck));
    }

    @GetMapping("find/{senderId}/{receiverId}")
    public ResponseEntity<List<Chat>> getChatBetweenUsers(@PathVariable Long senderId,@PathVariable Long receiverId){
        log.info("{getChatById} : Getting Chat of senderId {} receiverId {} ", senderId,receiverId);
        User sender = chatService.findUserById(senderId);
        User receiver = chatService.findUserById(receiverId);
        return ResponseEntity.ok().body(chatService.findChatBySenderAndReceiver(sender,receiver));
    }

    @PostMapping("/add")
    public ResponseEntity<Chat> addChat(@RequestBody ChatKey ck){
        Chat chat = chatService.fromChatKeytoChat(ck);
        log.info("{addChat} : Adding Chat of senderId {} receiverId {} messageId {}",
                chat.getId().getSenderId(),chat.getId().getReceiverId(),chat.getId().getMessageId());
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath ().path("api/chat/add").toUriString());
        return ResponseEntity.created(uri).body(chatService.addChat(chat));
    }

    @PutMapping("/update")
    public ResponseEntity<Chat> updateChat(@RequestBody ChatKey ck){
        Chat chat = chatService.fromChatKeytoChat(ck);
        log.info("{updateChat} : Updating Chat of senderId {} receiverId {} messageId {}",
                chat.getId().getSenderId(),chat.getId().getReceiverId(),chat.getId().getMessageId());
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath ().path("api/chat/update").toUriString());
        return ResponseEntity.created(uri).body(chatService.updateChat(chat));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteChat(@RequestBody ChatKey ck){
        log.info("{deleteChat} : Deleting Chat of senderId {} receiverId {} messageId {}",
                ck.getSenderId(),ck.getReceiverId(),ck.getMessageId());
        chatService.deleteChat(ck);
        return ResponseEntity.noContent().build();
    }
}