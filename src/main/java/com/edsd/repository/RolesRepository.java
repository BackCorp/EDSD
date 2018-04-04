package com.edsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edsd.model.Role;

public interface RolesRepository extends JpaRepository<Role, Integer>, CrudRepository<Role, Integer> {
	
	public Role findByRoleIgnoreCase(String role);
	
}
