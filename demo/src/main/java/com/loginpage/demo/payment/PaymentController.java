package com.loginpage.demo.payment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    @GetMapping("/payment")
    public String paymentPage() {
        return "payment";
    }       
    @PostMapping("/payment")
    public String processPayment(@RequestParam("amount") String amount, Model model) {
        model.addAttribute("message", "Payment of Rs. " + amount + " processed successfully!");
        return "success";
    }
}
