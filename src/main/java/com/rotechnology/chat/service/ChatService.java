package com.rotechnology.chat.service;

import com.rotechnology.chat.entity.Message;
import com.rotechnology.chat.entity.User;

import java.util.List;

public interface ChatService {

    User addUser(User user);
    User updateUSer(User user);
    void deleteUser(long id);
    List<User> getUsers();

    Message addMessage(Message message);
    Message updateMessage(Message message);
    void deleteMessage(long id);
    List<Message> getMessages();
    Message findMessageById(long id);


}
