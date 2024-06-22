package com.fapethedev.tendance.chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p></p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ChatService
{
    private final MessageRepository messageRepository;

    public ChatMessage saveMessage(String sender, String receiver, String content, String contentType, String imageUrl) {
        ChatMessage message = new ChatMessage();
//        message.setSender(sender);
//        message.setReceiver(receiver);
//        message.setContent(content);
//        message.setTimestamp(LocalDateTime.now());
//        message.setContentType(contentType);
//        message.setImageUrl(imageUrl);
        return messageRepository.save(message);
    }

    public List<ChatMessage> getMessages(String sender, String receiver) {
        return messageRepository.findBySenderAndReceiver(sender, receiver);
    }
}
