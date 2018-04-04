package com.edsd.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsd.repository.NonLogementEdsdRepository;
import com.edsd.repository.PrimesEdsdRepository;
import com.edsd.repository.RappelsSalairesEdsdRepository;
import com.edsd.repository.RequestersRepository;
import com.edsd.repository.UsersRepository;
import com.edsd.service.StatsService;


@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("/api/admin")
@RestController
public class AdminController {
	
	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private StatsService statsService;
	@Autowired
	private RequestersRepository requesterRepo;
	@Autowired
	private PrimesEdsdRepository primesEdsdRepo;
	@Autowired
	private NonLogementEdsdRepository nonLogementEdsdRepo;
	@Autowired
	private RappelsSalairesEdsdRepository rappelsSalairesRepo;
	
	@GetMapping("/")
    public String AdminMainPage() {
        return "Admin page";
    }
	
	// in the future, this should return an object containing all the stats
	@GetMapping("/stats")
	public StatsService getStats() {
		statsService.setEnabledAgentCount((int)usersRepo.countByRolesRoleLikeAndActiveTrue("AGENT"));
		statsService.setDisabledAgentCount((int)usersRepo.countByActiveFalse());
		statsService.setRequesterCount((int)requesterRepo.count());
		statsService.setPrimesEdsdCount((int)primesEdsdRepo.count());
		statsService.setNonLogementEdsdCount((int)nonLogementEdsdRepo.count());
		statsService.setRappelsSalairesEdsdCount((int)rappelsSalairesRepo.count());
		return statsService;
	}
		
	
}
