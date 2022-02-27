package com.ainigma100.kafkaexample.service;

import com.ainigma100.kafkaexample.model.request.Message;
import com.ainigma100.kafkaexample.model.request.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MessageService {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public void publish(MessageRequest messageRequest) {

        Message message = new Message(messageRequest.getMessage(), LocalDateTime.now());

        kafkaTemplate.send("ainigma100", message);
    }

}
