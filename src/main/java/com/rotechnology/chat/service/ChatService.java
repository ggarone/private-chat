package com.rotechnology.chat.service;

import com.rotechnology.chat.entity.User;

import java.util.List;

public interface ChatService {

    User addUser(User user);
    User updateUSer(User user);
    void deleteUser(long id);
    List<User> getUsers();


}
