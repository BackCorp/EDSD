package com.edsd.Controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsd.domain.Edsd;
import com.edsd.model.PrimesEdsd;
import com.edsd.model.PrimesGrade;
import com.edsd.model.PrimesIndices;
import com.edsd.model.PrimesLieesAuGradeOuCategorie;
import com.edsd.model.PrimesLieesAuxIndices;
import com.edsd.model.RequestHolder;
import com.edsd.model.Requester;
import com.edsd.model.Role;
import com.edsd.repository.PrimesLieesAuGadeOuCategorieRepository;
import com.edsd.repository.PrimesLieesAuxIndicesRepository;
import com.edsd.repository.RequestersRepository;
import com.edsd.repository.UsersRepository;
import com.edsd.service.StatsService;


@RequestMapping("/api/edsd")
@RestController
public class MainController {

	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private StatsService statsService;
	@Autowired
	private RequestersRepository requesterRepo;
	@Autowired
	private PrimesLieesAuGadeOuCategorieRepository primesGradeRepo;
	@Autowired
	private PrimesLieesAuxIndicesRepository primesIndicesRepo;
	@Autowired
	private Edsd edsd;
	
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
		statsService.setUserCount((int)usersRepo.count());
		statsService.setAgentCount((int)usersRepo.countByRolesRoleLike("AGENT"));
		statsService.setAdminCount((int)usersRepo.countByRolesRoleLike("ADMIN"));
		statsService.setTotalRequesters((int)requesterRepo.count());
		return statsService;
	}
		
    @PostMapping("/primes")
    public void test(@RequestBody RequestHolder rh, Principal principal) {
    	PrimesIndices primesIndices = rh.getPrimesIndices();
    	PrimesGrade primesGrade = rh.getPrimesGrade();  
    	Requester requester = null;
    	Optional<Requester> req = requesterRepo.findByAccountNumber(rh.getRequesterAccountNumber());
    	if(req.isPresent()) {
    		requester = req.get();
    	}
    	
    	System.out.println("=========================");
    	edsd.getPrimesEdsd(primesIndices, primesGrade, principal, requester);
//    	List<PrimesLieesAuxIndices> primesLieesAuxIndices = primesIndicesRepo.findByGroupeAndClasseIgnoreCase(rh.getPrimesIndices().getGroupe().trim(), rh.getPrimesIndices().getClasse().trim());
//    	System.out.println(rh.getPrimesIndices());
//    	System.out.println(primesLieesAuxIndices);
//    	System.out.println(edsd.getComputedPrimesGrade(rh.getPrimesGrade()));
//    	System.out.println(edsd.getComputedPrimes(rh.getPrimesIndices(), rh.getPrimesGrade()));
//    	System.out.println((pl.getEndDate().getTime() - pl.getStartDate().getTime())/(3600*24*1000));
//    	System.out.println(edsd.getComputedPrimes(rh.getPrimesIndices(), rh.getPrimesGrade()));
//    	return primesGradeRepo.findByGradeOuCategorieAndClasseIgnoreCase("A1", "Classe 1");
    }
    
    @GetMapping("/primes")
    public PrimesEdsd getAllPrimesEdsd(Principal principal) {
//    	Principal principal = null;
    	System.out.println("===================");
		System.out.println(principal.getName());
    	return null;
    }
    
    @GetMapping("/primes/{requesterAccountNumber}")
    public PrimesEdsd getAllPrimesEdsdByRequesterAccountNumber() {
    	return null;
    }
    
}
