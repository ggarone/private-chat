package com.rotechnology.chat.service;

import com.rotechnology.chat.entity.Message;
import com.rotechnology.chat.entity.User;
import com.rotechnology.chat.repository.ChatRepo;
import com.rotechnology.chat.repository.MessageRepo;
import com.rotechnology.chat.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service @RequiredArgsConstructor
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
                .orElseThrow(() -> new EntityNotFoundException());
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
                .orElseThrow(()-> new EntityNotFoundException());
    }
}
