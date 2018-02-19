package com.edsd.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edsd.model.Role;

@RequestMapping("/api")
@RestController
public class MainController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public ArrayList<Role> home() {
    	ArrayList<Role> arr = new ArrayList<>();
        arr.add(new Role(1, "AGENT"));
        return arr;
    }

    @GetMapping("/loginFailure")
    public String LoginFailure() {
        return "Login Failure";
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }
    
    @GetMapping("/logout")
    public ArrayList<String> logOut() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Logged out");
        
        return arr;
    }
}
