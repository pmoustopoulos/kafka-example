package com.ainigma100.kafkaexample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * This class is responsible to creating Topics.
 * Topics: a particular stream of data similar to tables in a db (without all the constraints).
 * A topic is identified by its name.
 *
 * Topics are split in Partitions.
 * Each partition is ordered. Each message within a partition gets an incremental id, called offset
 */
@Configuration
public class KafkaTopicConfig {

    // @Bean will instantiate this method and we will get a new Topic
    @Bean
    public NewTopic ainigma100Topic() {
        return TopicBuilder.name("ainigma100")
                .build();
    }

}
