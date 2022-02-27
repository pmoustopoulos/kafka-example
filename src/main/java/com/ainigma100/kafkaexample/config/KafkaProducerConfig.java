package com.ainigma100.kafkaexample.config;

import com.ainigma100.kafkaexample.model.request.Message;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    // this will holder the bootstrap server url
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    /**
     * This is a configuration that will be passed to a producer factory. It has to be returned as a Map data structure
     * @return
     */
    public Map<String, Object> producerConfig() {
        Map<String, Object> properties = new HashMap<>();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return properties;
    }

    /**
     * This is the producer factory which is responsible for creating producer instances.
     * Message is our custom object
     * @return
     */
    @Bean
    public ProducerFactory<String, Message> producerFactory() {
        return new DefaultKafkaProducerFactory<>(this.producerConfig());
    }


    /**
     * This method allows us to send messages
     * @param producerFactory
     * @return
     */
    @Bean
    public KafkaTemplate<String, Message> kafkaTemplate(
            ProducerFactory<String, Message> producerFactory
    ) {
        return new KafkaTemplate<>(producerFactory);
    }


}
