package com.fapethedev.tendance.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "messages")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ChatMessage {
    @Id
    private String id;
    private String sender;
    private String receiver;
    private String content;
    private LocalDateTime timestamp;
    private String contentType; // "text" ou "image"
    private String imageUrl; // URL de l'image si contentType est "image"

    // Getters et Setters
}
