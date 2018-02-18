package com.edsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edsd.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    
	public Optional<User> findByUsername(String username);
	
}


