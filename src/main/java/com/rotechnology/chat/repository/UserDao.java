package com.rotechnology.chat.repository;

import com.rotechnology.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
