package com.rotechnology.chat.service;

import com.rotechnology.chat.entity.Message;
import com.rotechnology.chat.entity.User;
import com.rotechnology.chat.repository.ChatRepo;
import com.rotechnology.chat.repository.MessageRepo;
import com.rotechnology.chat.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final UserRepo userRepo;
    private final MessageRepo messageRepo;
    private final ChatRepo chatRepo;

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User findUserById(long id) {
        return null;
    }

    @Override
    public Message addMessage(Message message) {
        return null;
    }

    @Override
    public Message updateMessage(Message message) {
        return null;
    }

    @Override
    public void deleteMessage(long id) {

    }

    @Override
    public List<Message> getMessages() {
        return null;
    }

    @Override
    public Message findMessageById(long id) {
        return null;
    }
}
