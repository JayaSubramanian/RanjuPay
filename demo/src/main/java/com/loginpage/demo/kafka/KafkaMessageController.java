package com.loginpage.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KafkaMessageController {
    @Autowired
    private KafkaMessageStore messageStore;

    @GetMapping("/kafka-messages")
    public String showMessages(Model model) {
        model.addAttribute("messages", messageStore.getMessages());
        return "kafka-messages";
    }
}
