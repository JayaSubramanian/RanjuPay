package com.loginpage.demo.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.loginpage.demo.service.LoginService;
@Controller
@SessionAttributes("name")
public class LoginController {
    @Autowired
    LoginService service; 
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model, @RequestParam(value="error", required= false)String error){
        if(error!= null) {
            model.put("errorMessage", "Invalid username or password");
        }
        return "login";
    }
    @GetMapping("/welcome")
    public String welcomePage(ModelMap model, java.security.Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        model.addAttribute("name", principal.getName());
        return "welcome";
    }  
}









