package com.ainigma100.kafkaexample;

import com.ainigma100.kafkaexample.model.request.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }


    /**
     *
     * @param kafkaTemplate the one we configured in KafkaProducerConfig
     * @return
     */
    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Message> kafkaTemplate) {
        return args -> {
            // keep in mind that the topic was configured in KafkaTopicConfig class
//            kafkaTemplate.send("ainigma100", "Hello Kafka :-)");
            for (int i = 0; i < 10; i++) {
                kafkaTemplate.send("ainigma100",
                        new Message("Hello Kafka :-) " + i , LocalDateTime.now())
                );
            }
        };
    }

}
