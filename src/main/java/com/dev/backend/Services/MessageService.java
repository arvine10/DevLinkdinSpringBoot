package com.dev.backend.Services;

import com.dev.backend.Entities.Message;
import com.dev.backend.Repositories.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public Message addMessage(Message msg){
        return this.messageRepository.save(msg);
    }


}
