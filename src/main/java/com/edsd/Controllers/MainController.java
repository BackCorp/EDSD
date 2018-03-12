package com.edsd.Controllers;

import java.util.ArrayList;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edsd.model.Role;


@RequestMapping("/api")
@RestController
public class MainController {

	@GetMapping("/home")
    public ArrayList<Role> home() {
		// just a test
    	ArrayList<Role> arr = new ArrayList<>();
        arr.add(new Role("AGENT"));
        return arr;
    }

	
    
}
