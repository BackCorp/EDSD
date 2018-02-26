package com.edsd.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/")
@RestController
public class LoginController {

	@GetMapping("/")
	public String FallBackController() {
		
		return "404";
		
	}
	
	@GetMapping("/loginFailure")
    public String LoginFailure() {
        return "Login Failure";
    }
}
