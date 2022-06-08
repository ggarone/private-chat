package com.rotechnology.chat.service;

import com.rotechnology.chat.entity.Chat;
import com.rotechnology.chat.entity.ChatKey;
import com.rotechnology.chat.entity.Message;
import com.rotechnology.chat.entity.User;

import java.util.List;

public interface ChatService {

    User addUser(User user);
    User updateUser(User user);
    void deleteUser(long id);
    List<User> getUsers();
    User findUserById(long id);

    Message addMessage(Message message);
    Message updateMessage(Message message);
    void deleteMessage(long id);
    List<Message> getMessages();
    Message findMessageById(long id);

    Chat addChat(Chat chat);
    Chat updateChat(Chat chat);
    void deleteChat(ChatKey ck);
    List<Chat> getChats();
    Chat findChatByCompositeKey(ChatKey ck);
    List<Chat> findChatBySenderAndReceiver(User sender,User receiver);
    Chat fromChatKeytoChat(ChatKey ck);
}
