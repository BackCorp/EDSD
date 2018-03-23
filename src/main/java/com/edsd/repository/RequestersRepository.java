package com.edsd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.edsd.model.Requester;

public interface RequestersRepository extends JpaRepository<Requester, Integer>, CrudRepository<Requester, Integer> {

	@Transactional(readOnly = true)
	public List<Requester> findAll();
	
	@Transactional(readOnly = true)
	public List<Requester> findTop10ByAccountNumberLikeOrFirstNameLikeOrLastNameLikeIgnoreCase(String accounNumber, String firstName, String lastName);
	
	public Optional<Requester> findByAccountNumber(String accountNumber);
	
}
