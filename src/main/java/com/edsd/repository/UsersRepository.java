package com.edsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edsd.model.User;

import java.util.List;
import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {
    
	public Optional<User> findByUsername(String username);
	
	//public Optional<User> findByUsernameLikeOrFirstNameLikeOrLastNameLike(String username, String firstName, String lastName);
	
	public List<User> findTop10ByUsernameOrFirstNameOrLastNameLikeIgnoreCase(String username, String firstName, String lastName);
	
}


