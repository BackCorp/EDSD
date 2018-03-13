package com.edsd.Controllers;


import java.security.Principal;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsd.model.User;


@RequestMapping("/api/login")
@RestController
public class LoginController {

	@GetMapping("/fallback")
	public String FallBackController() {
		
		return "404";
		
	}
	
	@GetMapping("/loginFailure")
    public String LoginFailure() {
        return "Login Failure";
    }
	
	@GetMapping("/user")
    public User AuthUser(Principal principal) {
        User user = ((User)principal);
        user.setPassword("");
        return user;
    }

}
