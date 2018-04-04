package com.edsd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edsd.model.PrimesLieesAuxIndices;


public interface PrimesLieesAuxIndicesRepository extends JpaRepository<PrimesLieesAuxIndices, Integer>, CrudRepository<PrimesLieesAuxIndices, Integer> {

	public List<PrimesLieesAuxIndices> findByGroupeIgnoreCase(String groupe);
	
	public List<PrimesLieesAuxIndices> findByGroupeAndIndemniteLikeIgnoreCase(String groupe, String indemnite);
	
}
