package com.edsd.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsd.domain.PlaceHolder;
import com.edsd.model.PrimesEdsd;
import com.edsd.model.Role;
import com.edsd.model.User;
import com.edsd.repository.NonLogementEdsdRepository;
import com.edsd.repository.PrimesEdsdRepository;
import com.edsd.repository.RappelsSalairesEdsdRepository;
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
	@Autowired
	private PrimesEdsdRepository primesEdsdRepo;
	@Autowired
	private NonLogementEdsdRepository nonLogementEdsdRepo;
	@Autowired
	private RappelsSalairesEdsdRepository rappelsSalairesEdsdRepo;
	
	@GetMapping("")
	public List<User> findAllAgents() {
		return usersRepo.findAll().parallelStream().map(user -> {
			user.setPassword("");
			return user;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/primes")
	public List<PlaceHolder> getAllPrimes() {
		return primesEdsdRepo.findAll().parallelStream().map(primesEdsd -> {
			return new PlaceHolder(
					primesEdsd, primesEdsd.getCreatedBy().getUsername(), 
					primesEdsd.getCreatedBy().getFirstName(), primesEdsd.getCreatedBy().getLastName());
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/nonLogements")
	public List<PlaceHolder> getAllNonLogements() {
		return nonLogementEdsdRepo.findAll().parallelStream().map(nonLegementsEdsd -> {
			return new PlaceHolder(
				nonLegementsEdsd, nonLegementsEdsd.getCreatedBy().getUsername(), 
				nonLegementsEdsd.getCreatedBy().getFirstName(), nonLegementsEdsd.getCreatedBy().getLastName());
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/rappelsSalaires")
	public List<PlaceHolder> getAllRappelsSalaires() {
		return rappelsSalairesEdsdRepo.findAll().parallelStream().map(rappelsSalairesEdsd -> {
			return new PlaceHolder(
				rappelsSalairesEdsd, rappelsSalairesEdsd.getCreatedBy().getUsername(), 
				rappelsSalairesEdsd.getCreatedBy().getFirstName(), 
				rappelsSalairesEdsd.getCreatedBy().getLastName());
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/search/{token}")
	public List<User> findByUsernameFirstNameLastNameLike(@PathVariable("token") String token) {
	    List<User> users = usersRepo.findTop10ByUsernameLikeAndActiveTrueOrFirstNameLikeAndActiveTrueOrLastNameLikeAndActiveTrueIgnoreCase("%"+token+"%", "%"+token+"%", "%"+token+"%");
	    users.forEach(user -> {
	    	user.setPassword("");
	    });
	    return users;
	}
	
	@GetMapping("/disabled/search/{token}")
	public List<User> findDisabledByUsernameFirstNameLastNameLike(@PathVariable("token") String token) {
	    List<User> users = usersRepo.findTop10ByUsernameLikeAndActiveFalseOrFirstNameLikeAndActiveFalseOrLastNameLikeAndActiveFalseIgnoreCase("%"+token+"%", "%"+token+"%", "%"+token+"%");
	    users.forEach(user -> {
	    	user.setPassword("");
	    });
	    return users;
	}
	
	@GetMapping("/{username}")
	public User findAgentByUsername(@PathVariable("username") String username) {
		Optional<User> user =  usersRepo.findByUsernameIgnoreCase(username);
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
	
	@GetMapping("/reset/{username}")
	public User findUsernameToBeReset(@PathVariable("username") String username) {
		return findAgentByUsername(username);
	}
	
	@PutMapping("/reset/{username}")
	public User UpdateAgentPassword(@PathVariable("username") String username, @RequestBody User user) {
		Optional<User> u = usersRepo.findByUsername(username); 
		if(u.isPresent()) {
			u.get().setPassword(user.getPassword());
			return usersRepo.save(u.get());
		}
		return null;
	}
	
	@PutMapping("/{username}")
	public User UpdateAgentByUsername(@PathVariable("username") String username, @RequestBody User user) {
		Optional<User> us = usersRepo.findByUsername(user.getUsername());
		User u = null;
		if(us.isPresent()) {
			if(us.get().getActive() && user.getActive()) {
				u = usersRepo.save(getUpdatedUser(us.get(), user));
				u.setPassword("");
			} else if(!us.get().getActive() && user.getActive()) {
				us.get().setActive(true);
				us.get().getRoles().clear();
				us.get().getRoles().add(rolesRepo.findByRoleIgnoreCase("AGENT"));
				u = usersRepo.save(us.get());
				u.setPassword("");
			} else if(us.get().getActive() && !user.getActive()) {
				us.get().setActive(false);
				us.get().getRoles().clear();
				us.get().getRoles().add(rolesRepo.findByRoleIgnoreCase("NO_ROLE"));
				u = usersRepo.save(us.get());
				u.setPassword("");
			}
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
