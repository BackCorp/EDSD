package com.edsd.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edsd.model.Role;
import com.edsd.repository.UsersRepository;
import com.edsd.service.StatsService;


@RequestMapping("/api")
@RestController
public class MainController {

	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private StatsService statsService;

	@GetMapping("/home")
    public ArrayList<Role> home() {
		// just a test
    	ArrayList<Role> arr = new ArrayList<>();
        arr.add(new Role("AGENT"));
        return arr;
    }

	// in the future, this should return an object containing all the stats
	@GetMapping("/stats")
	public StatsService getStats() {
		statsService.setUserCount(usersRepo.count());
		statsService.setAgentCount(usersRepo.countByRolesRoleLike("AGENT"));
		statsService.setAdminCount(usersRepo.countByRolesRoleLike("ADMIN"));
		return statsService;
	}
		
    
}
