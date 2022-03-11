package com.amateo.java.examples.messaging.kafka.agents.consumer;

import com.amateo.java.examples.messaging.kafka.event.CustomerEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerEventConsumer {

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.groupId}")
    public void consumeEvents(final List<CustomerEvent> customerEvents) {
        customerEvents.forEach(
                customerEvent -> log.info("Consume costumer id: '%s'".formatted(customerEvent.getId())));
    }

}
