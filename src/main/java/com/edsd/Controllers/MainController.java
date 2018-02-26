package com.edsd.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edsd.model.Role;
import com.edsd.model.User;
import com.edsd.repository.UsersRepository;

@RequestMapping("/api")
@RestController
public class MainController {

	@GetMapping("/home")
    public ArrayList<Role> home() {
		
    	ArrayList<Role> arr = new ArrayList<>();
        arr.add(new Role(1, "AGENT"));
        return arr;
    }

	
    
}