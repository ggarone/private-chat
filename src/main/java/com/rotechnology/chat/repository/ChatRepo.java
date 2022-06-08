package com.rotechnology.chat.repository;

import com.rotechnology.chat.entity.Chat;
import com.rotechnology.chat.entity.ChatKey;
import com.rotechnology.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Long> {
    void deleteChatById(ChatKey ck);
    Optional<Chat> findChatById(ChatKey ck);

}
