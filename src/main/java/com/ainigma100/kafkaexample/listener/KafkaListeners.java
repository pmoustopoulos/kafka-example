package com.ainigma100.kafkaexample.listener;

import com.ainigma100.kafkaexample.model.request.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaListeners {


    /**
     * This method allows us to listen our Topic
     * @param data received by the listener
     */
    @KafkaListener(
            topics = "ainigma100",
            groupId = "ainigma100GroupId",
            containerFactory = "messageFactory"
    )
    void listener(Message data) {
        System.out.println("Listener received: " + data + " 😁");
    }

}
