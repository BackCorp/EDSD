package com.edsd.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edsd.model.PrimesEdsd;
import com.edsd.model.PrimesGrade;
import com.edsd.model.PrimesIndices;
import com.edsd.model.PrimesLieesAuxIndices;
import com.edsd.repository.PrimesLieesAuGadeOuCategorieRepository;
import com.edsd.repository.PrimesLieesAuxIndicesRepository;

@Component
public class Edsd {
	
	@Autowired
	private PrimesLieesAuGadeOuCategorieRepository primesGradeRepo;
	@Autowired
	private PrimesLieesAuxIndicesRepository primesIndicesRepo;
	@Autowired
	private PrimesEdsd primesEdsd;
	
	private double computedPrimesGrade;
	private double computedPrimesIndices;
	private double computedprimes;
	
	

	public Edsd() {}
	
	
	public Edsd(double computedPrimesGrade, double computedPrimesIndices) {
		super();
		this.computedPrimesGrade = computedPrimesGrade;
		this.computedPrimesIndices = computedPrimesIndices;
	}


	public double getComputedPrimesGrade(PrimesGrade primesGrade) {
		double primesGradeMontant = primesGradeRepo.findByGradeOuCategorieAndClasseIgnoreCase(primesGrade.getGrade(), primesGrade.getClasse()).getMontant();
		System.out.println(primesGradeMontant);
		return computedPrimesGrade = (primesGradeMontant - primesGradeMontant * 5.28/100)*(primesGrade.getEndDate().getTime() - primesGrade.getStartDate().getTime())/(3600*1000*24*30.0);
	}
	
	public double getComputedPrimesIndices(PrimesIndices primesIndices) {
		List<PrimesLieesAuxIndices> primesLieesAuxIndices = primesIndicesRepo.findByGroupeAndClasseIgnoreCase(primesIndices.getGroupe(), primesIndices.getClasse());
		System.out.println(primesLieesAuxIndices);
		primesLieesAuxIndices.forEach(primeLieesAuxIndices -> {
			computedPrimesIndices += (primeLieesAuxIndices.getMontant() - primeLieesAuxIndices.getMontant() * 5.28/100)*(primesIndices.getEndDate().getTime() - primesIndices.getStartDate().getTime())/(3600*1000*24*30.0);
		});
		return computedPrimesIndices;
	}

	public double getComputedPrimes(PrimesIndices primesIndices, PrimesGrade primesGrade) {
		return computedprimes = getComputedPrimesIndices(primesIndices)  + getComputedPrimesGrade(primesGrade) ;
	}
	
	public void setComputedprimes(double computedprimes) {
		this.computedprimes = computedprimes;
	}
	
	public PrimesEdsd getPrimesEdsd(PrimesIndices primesIndices, PrimesGrade primesGrade) {
		primesEdsd.setPrimesTotales(this.getComputedPrimes(primesIndices, primesGrade));
		primesEdsd = new PrimesEdsd(newDateTime);
		return primesEdsd;
		
	}
}
