package com.loginpage.demo.kafka;

import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class KafkaMessageStore {
    private final List<String> messages = Collections.synchronizedList(new LinkedList<>());

    public void addMessage(String message) {
        messages.add(0, message); // add to the front for latest first
        if (messages.size() > 20) {
            messages.remove(messages.size() - 1); // keep only last 20
        }
    }

    public List<String> getMessages() {
        return new LinkedList<>(messages);
    }
}
