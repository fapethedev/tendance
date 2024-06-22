package com.fapethedev.tendance.chat;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 *
 */
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Document(value = "chat_rooms")
public class ChatRoom
{
    @Id
    private UUID id;
    private UUID chatId;
    private UUID senderId;
    private UUID recipientId;
}
