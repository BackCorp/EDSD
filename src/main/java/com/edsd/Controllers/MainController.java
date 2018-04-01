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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.edsd.domain.Edsd;
import com.edsd.domain.NonLogementEdsdException;
import com.edsd.model.NonLogementEdsd;
import com.edsd.model.PrimesEdsd;
import com.edsd.model.RappelsSalairesEdsd;
import com.edsd.model.RequestHolder;
import com.edsd.model.Role;
import com.edsd.model.User;
import com.edsd.repository.PrimesEdsdRepository;
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
	private PrimesEdsdRepository primesEdsdRepo;
	@Autowired
	private RequestersRepository requesterRepo;
	@Autowired
	private Edsd edsd;
	
	private List<Object> edsdObjs = new ArrayList<>();
	
	@GetMapping("/home")
    public ArrayList<Role> home() {
		// just a test
    	ArrayList<Role> arr = new ArrayList<>();
        arr.add(new Role("AGENT"));
        return arr;
    }

    @PostMapping("")
    public List<Object> createPrimesEdsd(@RequestBody RequestHolder requestHolder, Principal principal) {
    	if(!(edsdObjs == null || edsdObjs.isEmpty())) {
    		edsdObjs.clear();
    	}
    	usersRepo.findByUsername(principal.getName()).ifPresent(user -> {
    		requesterRepo.findByAccountNumber(requestHolder.getRequesterAccountNumber()).ifPresent(requester -> {
        		if(!(requestHolder.getPrimesGrade() == null || requestHolder.getPrimesIndices() == null)) {
        			edsdObjs.add(edsd.createPrimesEdsd(user, requester, requestHolder.getPrimesIndices(), requestHolder.getPrimesGrade(), requestHolder.getRetenues()));
        		}
        		if(requestHolder.getNonLogement() != null) {
        			edsdObjs.add(edsd.createNonLogement(user, requester, requestHolder.getNonLogement()));
        		}
        		if(requestHolder.getRappelsSalaires() != null) {
        			edsdObjs.add(edsd.createRappelsSalaires(user, requester, requestHolder.getRappelsSalaires()));
        		}
        	});
    	});
    	return edsdObjs;
    }
    
    @GetMapping("/test")
    public List<PrimesEdsd> test() {
    	return primesEdsdRepo.findByBelongsToRequester(requesterRepo.findByRequesterId(1).get());
    }
    
    @GetMapping("/primes")
    public Set<PrimesEdsd> getAllPrimesEdsd(Principal principal) {
    	Set<PrimesEdsd> primesEdsdSet = Collections.<PrimesEdsd>emptySet();
		Optional<User> optional = usersRepo.findByUsername(principal.getName());
		if(optional.isPresent()) {
			primesEdsdSet = optional.get().getPrimesEdsd();
		}
    	return primesEdsdSet;
    }
    
    @GetMapping("/nonLogements")
    public Set<NonLogementEdsd> getAllNonLogementsEdsd(Principal principal) {
    	Set<NonLogementEdsd> nonLogementEdsd = Collections.<NonLogementEdsd>emptySet();
		Optional<User> optional = usersRepo.findByUsername(principal.getName());
		if(optional.isPresent()) {
			nonLogementEdsd = optional.get().getNonLogementEdsd();
		}
    	return nonLogementEdsd;
    }
    
    @GetMapping("/rappelsSalaires")
    public Set<RappelsSalairesEdsd> getAllrappelsSalairesEdsd(Principal principal) {
    	Set<RappelsSalairesEdsd> rappelsSalairesEdsd = Collections.<RappelsSalairesEdsd>emptySet();
		Optional<User> optional = usersRepo.findByUsername(principal.getName());
		if(optional.isPresent()) {
			rappelsSalairesEdsd = optional.get().getRappelsSalairesEdsd();
		}
    	return rappelsSalairesEdsd;
    }
    
//    @GetMapping("/primes/{requesterAccountNumber}")
//    public PrimesEdsd getAllPrimesEdsdByRequesterAccountNumber() {
//    	return null;
//    }  
    
}

