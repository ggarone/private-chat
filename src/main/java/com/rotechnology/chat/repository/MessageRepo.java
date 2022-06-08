package com.rotechnology.chat.repository;

import com.rotechnology.chat.entity.Message;
import com.rotechnology.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepo extends JpaRepository<Message,Long> {
    Optional<Message> findMessageById(long id);
    void deleteMessageById(long id);
}
