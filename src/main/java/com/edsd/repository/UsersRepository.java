package com.edsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.edsd.model.User;

import java.util.List;
import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {
	    
	public Optional<User> findByUsername(String username);
	
	public Optional<User> findByUsernameIgnoreCase(String username);
	
	public Optional<User> findByUsernameAndActiveFalseIgnoreCase(String username);
	
	@Transactional(readOnly = true)
	public List<User> findTop10ByUsernameLikeAndActiveTrueOrFirstNameLikeAndActiveTrueOrLastNameLikeAndActiveTrueIgnoreCase(String username, String firstName, String lastName);
	
	@Transactional(readOnly = true)
	public List<User> findTop10ByUsernameLikeAndActiveFalseOrFirstNameLikeAndActiveFalseOrLastNameLikeAndActiveFalseIgnoreCase(String username, String firstName, String lastName);
	
	@Transactional(readOnly = true)
	public List<User> findAll();
	
	public long count();
	
	public long countByRolesRoleLikeAndActiveTrue(String role); 
	
	public long countByActiveFalse(); 
	
}


