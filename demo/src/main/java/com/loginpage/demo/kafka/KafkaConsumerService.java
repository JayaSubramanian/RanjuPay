package com.loginpage.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    private KafkaMessageStore messageStore;

    @KafkaListener(topics = "payments", groupId = "group_id")
    public void consume(String message) {
        messageStore.addMessage(message);
        System.out.println("Received message: " + message);
    }
}
