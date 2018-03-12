package com.edsd.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsd.model.Role;
import com.edsd.model.User;
import com.edsd.repository.UsersRepository;

@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("/api/agents")
@RestController
public class AgentController {
	
	@Autowired
	private UsersRepository usersRepo;
	
	@GetMapping("")
	public List<User> findAllAgents() {
		return usersRepo.findAll();
	}
	
	@GetMapping("/search/{token}")
	public List<User> findByUsernameFirstNameLastNameLike(@PathVariable("token") String token) {
	    return usersRepo.findTop10ByUsernameLikeOrFirstNameLikeOrLastNameLikeIgnoreCase("%"+token+"%", "%"+token+"%", "%"+token+"%");
	}
	
	@GetMapping("/{username}")
	public User findAgentByUsername(@PathVariable("username") String username) {
		Optional<User> user =  usersRepo.findByUsernameAndActiveTrue(username);
		if(user.isPresent()) {
			if(user.get().getRoles().stream().anyMatch(role -> role.getRole().equals("ADMIN"))) {
				return null;
			} else {
				return user.get();
			}
		} 
		return null;
	}
	
	@PutMapping("/{username}")
	public User UpdateAgentByUsername(@PathVariable("username") String username) {
//		ArrayList<Role> arr = new ArrayList<>();
//        arr.add(new Role("AGENT"));
        return usersRepo.findByUsername(username).get();
	}
	
}
