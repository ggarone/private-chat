package com.rotechnology.chat;

import com.rotechnology.chat.entity.Chat;
import com.rotechnology.chat.entity.ChatKey;
import com.rotechnology.chat.entity.Message;
import com.rotechnology.chat.entity.User;
import com.rotechnology.chat.service.ChatService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PrivateChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrivateChatApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ChatService chatService){
		return args -> {
			User U1 = new User(1L,"Matteo","root");
			User U2 = new User(2L,"Giuseppe", "root");

			chatService.addUser(U1);
			chatService.addUser(U2);

			Message M1 = new Message(1L,"ciao", LocalDate.now());
			Message M2 = new Message(2L,"ciao, come stai?", LocalDate.now());

			chatService.addMessage(M1);
			chatService.addMessage(M2);

			ChatKey CK1 = new ChatKey(1L,2L,1L);
			ChatKey CK2 = new ChatKey(2L,1L,2L);
			chatService.addChat(new Chat(CK1,U1,U2,M1));
			chatService.addChat(new Chat(CK2,U2,U1,M2));
		};
	}
}
