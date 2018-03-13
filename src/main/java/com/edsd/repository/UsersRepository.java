package com.edsd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.edsd.model.IUser;
import com.edsd.model.Role;
import com.edsd.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;


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
	
	//public User save(User user);
	
	
}


