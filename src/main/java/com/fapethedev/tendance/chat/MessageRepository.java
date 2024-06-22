package com.fapethedev.tendance.chat;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p></p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface MessageRepository extends MongoRepository<ChatMessage, String>
{
    /**
     *
     * @param sender
     * @param receiver
     * @return
     */
    List<ChatMessage> findBySenderAndReceiver(String sender, String receiver);
}
