package com.loginpage.demo.enteramount;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AmountController {
	  @GetMapping("/enter-amount")
	    public String enteramountPage() {
	        return "enter-amount";
	    }		
		  @PostMapping("/enter-amount") 
		  public String StringshowPaymentPage(@RequestParam("amount") String amount, Model model) 
		  {
		  model.addAttribute("amount", amount); 
		  return "payment"; 
		  }
}
