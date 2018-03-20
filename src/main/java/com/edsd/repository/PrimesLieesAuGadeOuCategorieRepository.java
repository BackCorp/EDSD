package com.edsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edsd.model.PrimesLieesAuGradeOuCategorie;

public interface PrimesLieesAuGadeOuCategorieRepository extends JpaRepository<PrimesLieesAuGradeOuCategorie, Integer>, CrudRepository<PrimesLieesAuGradeOuCategorie, Integer>{

	public PrimesLieesAuGradeOuCategorie findByGradeOuCategorieAndClasseIgnoreCase(String grade, String classe);
	
}
