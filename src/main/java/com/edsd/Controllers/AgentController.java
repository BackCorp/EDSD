package com.edsd.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsd.model.Role;
import com.edsd.model.User;
import com.edsd.repository.RolesRepository;
import com.edsd.repository.UsersRepository;

@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("/api/agents")
@RestController
public class AgentController {
	
	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private RolesRepository rolesRepo;
	
	@GetMapping("")
	public List<User> findAllAgents() {
		return usersRepo.findAll();
	}
	
	@GetMapping("/search/{token}")
	public List<User> findByUsernameFirstNameLastNameLike(@PathVariable("token") String token) {
	    List<User> users = usersRepo.findTop10ByUsernameLikeOrFirstNameLikeOrLastNameLikeIgnoreCase("%"+token+"%", "%"+token+"%", "%"+token+"%");
	    users.forEach(user -> {
	    	user.setPassword("");
	    });
	    return users;
	}
	
	@GetMapping("/{username}")
	public User findAgentByUsername(@PathVariable("username") String username) {
		Optional<User> user =  usersRepo.findByUsernameAndActiveTrue(username);
		if(user.isPresent()) {
			if(user.get().getRoles().stream().anyMatch(role -> role.getRole().equals("ADMIN"))) {
				return null;
			} else {
				User u = user.get();
				u.setPassword("");
				return u;
			}
		} 
		return null;
	}
	
	@PutMapping("/{username}")
	public User UpdateAgentByUsername(@PathVariable("username") String username, @RequestBody User user) {
		Optional<User> us = usersRepo.findByUsername(user.getUsername());
		if(us.isPresent()) {
			User u = getUpdatedUser(us.get(), user);
			usersRepo.save(u).setPassword("");
			return u;
		} 
		return null;
	}
	
	private User getUpdatedUser(User userToBeUpdated, User userModel) {
		if(userToBeUpdated.getMidName() == null) {
			userToBeUpdated.setMidName("");
		}
		if(userModel.getMidName() == null) {
			userModel.setMidName("");
		}
		
		if(!userToBeUpdated.getFirstName().trim().equals(userModel.getFirstName().trim())) {
			userToBeUpdated.setFirstName(userModel.getFirstName()); 
		} 
		if(!userToBeUpdated.getLastName().trim().equals(userModel.getLastName().trim())) {
			userToBeUpdated.setLastName(userModel.getLastName());
		}
		if(!userToBeUpdated.getEmail().trim().equals(userModel.getEmail().trim())) {
			userToBeUpdated.setEmail(userModel.getEmail());
		}
		if(!userToBeUpdated.getMidName().trim().equals(userModel.getMidName().trim())) {
			userToBeUpdated.setMidName(userModel.getMidName());
		} 	
		if(userToBeUpdated.getActive() != userModel.getActive()) {
			userToBeUpdated.setActive(userModel.getActive());
		}
		if(userToBeUpdated.getRoles().size() < userModel.getRoles().size()) {
			userToBeUpdated = getUpdatedRoles(userToBeUpdated, userModel);
		}
		return userToBeUpdated;
	}
	
	private User getUpdatedRoles(User userToBeUpdated, User userModel) {
		HashSet<Role> roles = new HashSet<Role>();
		if(userToBeUpdated.getRoles().isEmpty()) {
			roles.add(rolesRepo.findByRoleIgnoreCase("AGENT"));
			userToBeUpdated.setRoles(roles);
		}
		return userToBeUpdated;
	}
	
}
