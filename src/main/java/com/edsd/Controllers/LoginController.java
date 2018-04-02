package com.edsd.Controllers;


import java.security.Principal;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public Principal AuthUser(Principal principal) {
        return principal;
    }

}
