package com.edsd.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsd.model.User;
import com.edsd.repository.UsersRepository;


@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("/api/admin")
@RestController
public class AdminController {
	
	@Autowired
	private UsersRepository usersRepo;
	
	@GetMapping("/")
    public String AdminMainPage() {
        return "Admin page";
    }
	
	
}
