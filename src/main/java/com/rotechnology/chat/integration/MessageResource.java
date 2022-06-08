package com.rotechnology.chat.integration;

import com.rotechnology.chat.entity.Message;
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
@RequestMapping("api/message")
@RequiredArgsConstructor
@Slf4j
public class MessageResource {
    private final ChatService chatService;

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages(){
        log.info("{getAllMessages} : Getting all Messages");
        return  ResponseEntity.ok().body(chatService.getMessages());
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") Long id){
        log.info("{getMessageById} : Getting message of id {}", id);
        return ResponseEntity.ok().body(chatService.findMessageById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Message> addMessage(@RequestBody Message message){
        log.info("{addMessage} : Adding message by id {}", message.getId());
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath ().path("api/message/add").toUriString());
        return ResponseEntity.created(uri).body(chatService.addMessage(message));
    }

    @PutMapping("/update")
    public ResponseEntity<Message> updateMessage(@RequestBody Message message){
        log.info("{updateMessage} : Updating message by id {}", message.getId());
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath ().path("api/message/update").toUriString());
        return ResponseEntity.created(uri).body(chatService.updateMessage(message));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteMessage(@PathVariable("id") Long id){
        log.info("{deleteMessage} : Deleting message of id {}", id);
        chatService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
