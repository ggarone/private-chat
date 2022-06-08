package com.rotechnology.chat.service;

import com.rotechnology.chat.entity.Chat;
import com.rotechnology.chat.entity.ChatKey;
import com.rotechnology.chat.entity.Message;
import com.rotechnology.chat.entity.User;
import com.rotechnology.chat.repository.ChatRepo;
import com.rotechnology.chat.repository.MessageRepo;
import com.rotechnology.chat.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor @Slf4j
public class ChatServiceImpl implements ChatService {
    private final UserRepo userRepo;
    private final MessageRepo messageRepo;
    private final ChatRepo chatRepo;

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new EntityNotFoundException("user"));
    }

    @Override
    public Message addMessage(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public Message updateMessage(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public void deleteMessage(long id) {
        messageRepo.deleteMessageById(id);
    }

    @Override
    public List<Message> getMessages() {
        return messageRepo.findAll();
    }

    @Override
    public Message findMessageById(long id) {
        return messageRepo.findMessageById(id)
                .orElseThrow(() -> new EntityNotFoundException("message"));
    }

    @Override
    public Chat addChat(Chat chat) {
        return chatRepo.save(chat);
    }

    @Override
    public Chat updateChat(Chat chat) {
        return chatRepo.save(chat);
    }

    @Override
    public void deleteChat(ChatKey ck) {
        chatRepo.deleteChatById(ck);
    }

    @Override
    public List<Chat> getChats() {
        return chatRepo.findAll();
    }

    @Override
    public Chat findChatByCompositeKey(ChatKey ck) {
        return chatRepo.findChatById(ck)
                .orElseThrow(() -> new EntityNotFoundException("chat"));
    }

    @Override
    public List<Chat> findChatBySenderAndReceiver(User sender, User receiver) {
        return this.getChats().stream()
                .filter(c -> (c.getId().getSenderId().equals(sender.getId()) && c.getId().getReceiverId().equals(receiver.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Chat fromChatKeytoChat(ChatKey ck) {
        User sender = findUserById(ck.getSenderId());
        User receiver = findUserById(ck.getReceiverId());
        Message message = findMessageById(ck.getMessageId());
        return new Chat(ck,sender,receiver,message);
    }
}
