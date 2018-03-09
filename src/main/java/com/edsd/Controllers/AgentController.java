package com.edsd.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsd.model.User;
import com.edsd.repository.UsersRepository;

@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("/api/agents")
@RestController
public class AgentController {
	
	@Autowired
	private UsersRepository usersRepo;
	
	@GetMapping("/{token}")
	public List<User> findByUsernameFirstNameLastNameLike(@PathVariable("token") String token) {
	    return usersRepo.findTop10ByUsernameOrFirstNameOrLastNameLikeIgnoreCase("%"+token+"%", "%"+token+"%", "%"+token+"%");
	}
	
//	@PostMapping("/")
//	public User createBy(@PathVariable("username") String username) {
//		return null;
//		//return usersRepo.findByUsername(username).get();
//	}
	
}
