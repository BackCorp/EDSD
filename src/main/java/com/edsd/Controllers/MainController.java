package com.edsd.Controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.edsd.model.User;
import com.edsd.repository.PrimesEdsdRepository;
import com.edsd.repository.PrimesLieesAuGadeOuCategorieRepository;
import com.edsd.repository.PrimesLieesAuxIndicesRepository;
import com.edsd.repository.RequestersRepository;
import com.edsd.repository.UsersRepository;
import com.edsd.service.StatsService;

@PreAuthorize("hasAnyRole('AGENT')")
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
	private PrimesEdsdRepository primesEdsdRepo;
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
    public PrimesEdsd createPrimesEdsd(@RequestBody RequestHolder rh, Principal principal) {
    	PrimesIndices primesIndices = rh.getPrimesIndices();
    	PrimesGrade primesGrade = rh.getPrimesGrade();  
    	List<PrimesEdsd> primesEdsds = null;
    	Requester requester = null;
    	Optional<Requester> req = requesterRepo.findByAccountNumber(rh.getRequesterAccountNumber());
    	if(req.isPresent()) {
    		requester = req.get();
    		primesEdsds = primesEdsdRepo.findByBelongsToRequester(requester);
    		if(primesEdsds.isEmpty()) {
    			return edsd.getPrimesEdsd(primesIndices, primesGrade, principal, requester);
    		}
    		return null;
    	}
    	return null;
    }
    
    @GetMapping("/test")
    public List<PrimesEdsd> test() {
    	return primesEdsdRepo.findByBelongsToRequester(requesterRepo.findByRequesterId(1).get());
    }
    
    @GetMapping("/primes")
    public Set<PrimesEdsd> getAllPrimesEdsd(Principal principal) {
    	Set<PrimesEdsd> primesEdsdSet = Collections.<PrimesEdsd>emptySet();;
		Optional<User> optional = usersRepo.findByUsername(principal.getName());
		if(optional.isPresent()) {
			primesEdsdSet = optional.get().getPrimesEdsd();
		}
    	return primesEdsdSet;
    }
    
//    @GetMapping("/primes/{requesterAccountNumber}")
//    public PrimesEdsd getAllPrimesEdsdByRequesterAccountNumber() {
//    	return null;
//    }
    
}
