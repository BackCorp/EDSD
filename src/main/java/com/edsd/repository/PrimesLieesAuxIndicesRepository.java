package com.edsd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edsd.model.PrimesLieesAuGradeOuCategorie;
import com.edsd.model.PrimesLieesAuxIndices;
import com.edsd.model.Requester;

public interface PrimesLieesAuxIndicesRepository extends JpaRepository<PrimesLieesAuxIndices, Integer>, CrudRepository<PrimesLieesAuxIndices, Integer> {

	public List<PrimesLieesAuxIndices> findByGroupeAndClasseIgnoreCase(String groupe, String classe);
	
}
