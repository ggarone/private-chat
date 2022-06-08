package com.rotechnology.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatKey implements Serializable {
    @Column(name = "sender_id")
    private Long senderId;
    @Column(name = "receiver_id")
    private Long receiverId;
    @Column(name = "message_id")
    private Long messageId;



}
