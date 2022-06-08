package com.rotechnology.chat.integration;

import com.rotechnology.chat.entity.User;
import com.rotechnology.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequiredArgsConstructor @Slf4j @RequestMapping("api/user")
public class UserResource {

    private final ChatService chatService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        log.info("{getAllUsers} : Getting all User");
        return ResponseEntity.ok().body(chatService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        log.info("{addUser} : Add User {}", user.getUsername());
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/add").toUriString());
        return ResponseEntity.created(uri).body(chatService.addUser(user));
    }

    @DeleteMapping("/delete/{id}") @Transactional
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        log.info("{deleteUser} : Delete User By Id {}", id);
        chatService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        log.info("{updateUser} : Update User By Id {}", user.getId());
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/update").toUriString());
        return ResponseEntity.created(uri).body(chatService.updateUser(user));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        log.info("{getUserById} Find User By Id {}", id);
        return ResponseEntity.ok().body(chatService.findUserById(id));
    }

}
