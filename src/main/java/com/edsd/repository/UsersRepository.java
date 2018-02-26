package com.edsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edsd.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {
    
	public Optional<User> findByUsername(String username);
	
}


