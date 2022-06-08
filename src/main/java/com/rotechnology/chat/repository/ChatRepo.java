package com.rotechnology.chat.repository;

import com.rotechnology.chat.entity.Chat;
import com.rotechnology.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Long> {
}
