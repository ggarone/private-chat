package com.rotechnology.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Chat {
    @EmbeddedId
    private ChatKey id;

    @ManyToOne
    @MapsId("senderId")
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @MapsId("receiverId")
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @ManyToOne
    @MapsId("messageId")
    @JoinColumn(name = "message_id")
    private Message message;
}
