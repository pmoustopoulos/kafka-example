package com.ainigma100.kafkaexample.controller;

import com.ainigma100.kafkaexample.model.request.MessageRequest;
import com.ainigma100.kafkaexample.model.request.Message;
import com.ainigma100.kafkaexample.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private final MessageService messageService;


    @PostMapping
    public void publish(@RequestBody MessageRequest messageRequest) {
        messageService.publish(messageRequest);
    }

}
