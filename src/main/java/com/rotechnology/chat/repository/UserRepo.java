package com.rotechnology.chat.repository;

import com.rotechnology.chat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserById(long id);
    void deleteUserById(long id);
}
