package com.amateo.java.examples.messaging.kafka.producer;

import com.amateo.java.examples.messaging.kafka.event.CustomerEvent;
import com.amateo.java.examples.messaging.kafka.event.Topic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerEventProducer {

    private final KafkaTemplate<String, CustomerEvent> kafkaTemplate;

    public void sendEvent(final CustomerEvent customerEvent) {
        kafkaTemplate.send(Topic.CUSTOMER_CREATION.getTopic(),
                String.valueOf(customerEvent.getId()),
                customerEvent);

        log.info("Send event to '%s' topic with id '%s'"
                .formatted(Topic.CUSTOMER_CREATION.getTopic(), customerEvent.getId()));
    }

}
