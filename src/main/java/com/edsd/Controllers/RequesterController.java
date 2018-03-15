package com.edsd.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsd.model.Requester;
import com.edsd.repository.RequestersRepository;


@RequestMapping("/api/requesters")
@RestController
public class RequesterController {

	@Autowired
	RequestersRepository requestersRepo;
	
	@GetMapping("/search/{token}")
	public List<Requester> findTop10ByAccountNumberFirstNameLastNameLikeIgnoreCase(@PathVariable("token") String token) {
	    return requestersRepo.findTop10ByAccountNumberLikeOrFirstNameLikeOrLastNameLikeIgnoreCase("%"+token+"%", "%"+token+"%", "%"+token+"%");
	}
	
}
