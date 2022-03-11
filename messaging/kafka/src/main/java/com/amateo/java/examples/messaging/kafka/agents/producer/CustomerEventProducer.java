package com.amateo.java.examples.messaging.kafka.agents.producer;

import com.amateo.java.examples.messaging.kafka.event.CustomerEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerEventProducer {

    private final KafkaTemplate<String, CustomerEvent> kafkaTemplate;
    private final String topic;

    public CustomerEventProducer(KafkaTemplate<String, CustomerEvent> kafkaTemplate,
                                 @Value("${kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendEvent(final CustomerEvent customerEvent) {
        kafkaTemplate.send(topic,
                String.valueOf(customerEvent.getId()),
                customerEvent);

        log.info("Send event to '%s' topic with id '%s'"
                .formatted(topic, customerEvent.getId()));
    }

}
