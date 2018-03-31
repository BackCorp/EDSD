package com.edsd.domain;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.edsd.model.PrimesEdsd;
import com.edsd.model.PrimesGrade;
import com.edsd.model.PrimesIndices;
import com.edsd.model.PrimesLieesAuxIndices;
import com.edsd.model.Requester;
import com.edsd.model.User;
import com.edsd.repository.PrimesEdsdRepository;
import com.edsd.repository.PrimesLieesAuGadeOuCategorieRepository;
import com.edsd.repository.PrimesLieesAuxIndicesRepository;
import com.edsd.repository.UsersRepository;

import java.security.Principal;
import java.sql.Date;

@Component
public class Edsd {
	
	@Autowired
	private PrimesLieesAuGadeOuCategorieRepository primesGradeRepo;
	@Autowired
	private PrimesLieesAuxIndicesRepository primesIndicesRepo;
	@Autowired
	private PrimesEdsdRepository primesEdsdRepo;
	@Autowired
	private PrimesEdsd primesEdsd;
	@Autowired
	private UsersRepository usersRepo;
	
	private double totalPrimesIndices;

	private final double TAX_PERCENTAGE = 5.28/100;
	private final int HOUR = 3600000;
	
	public Edsd() {}
	
	private double getNumberOfMonths(Date startDate, Date endDate) {
		return (endDate.getTime() - startDate.getTime() + HOUR)/(3600*1000*24*30.0);
	}
	
	private double getPrimesGradeTecniciteMontant(PrimesGrade primesGrade) {
		return primesGradeRepo.findByGradeOuCategorieAndClasseIgnoreCase(primesGrade.getGrade(), primesGrade.getClasse()).getMontant();
	}
	
	private double getComputedPrimesIndicesMontant(PrimesIndices primesIndices) {
		List<PrimesLieesAuxIndices> primeLieesAuxIndices = primesIndicesRepo.findByGroupeIgnoreCase(primesIndices.getGroupe());
		primeLieesAuxIndices.forEach(primeLieesAuxIndice -> {
			totalPrimesIndices += primeLieesAuxIndice.getMontant();
		});
		return totalPrimesIndices;
	}

	private double getComputedPrimesGrade(PrimesGrade primesGrade) {		
		return this.getPrimesGradeTecniciteMontant(primesGrade) * (1 - TAX_PERCENTAGE) * this.getNumberOfMonths(primesGrade.getStartDate(), primesGrade.getEndDate());
	}
	
	private double getComputedPrimesIndices(PrimesIndices primesIndices) {
		return this.getComputedPrimesIndicesMontant(primesIndices) * (1 - TAX_PERCENTAGE) * this.getNumberOfMonths(primesIndices.getStartDate(), primesIndices.getEndDate());
	}

	private double getComputedPrimes(PrimesIndices primesIndices, PrimesGrade primesGrade, double retenues) {
		return this.getComputedPrimesIndices(primesIndices)  + 
				this.getComputedPrimesGrade(primesGrade) - 
				this.getComputedRetenues(getNumberOfMonths(primesIndices.getStartDate(), primesIndices.getEndDate()), retenues);
	}
	
	private int roundUp(double number) {
		return (int)Math.round(number);
	}
	
	private double getComputedRetenues(double numberOfMonths, double montantRetenues) {
		return numberOfMonths * montantRetenues;
	}
	
	public PrimesEdsd createPrimesEdsd(User createdBy, Requester requester, PrimesIndices primesIndices, PrimesGrade primesGrade, double retenues) {
		double computedPrimes = getComputedPrimes(primesIndices, primesGrade, retenues);
		primesEdsd = new PrimesEdsd(
			createdBy,
			requester, 
			primesGrade.getStartDate(), 
			primesIndices.getEndDate(), 
			primesGrade.getGrade(), 
			primesGrade.getClasse(), 
			getPrimesGradeTecniciteMontant(primesGrade),
			primesIndices.getGroupe(), 
			primesIndices.getClasse(), 
			retenues,
			primesIndicesRepo.findByGroupeAndIndemniteLikeIgnoreCase(primesIndices.getGroupe(), "%astreinte").get(0).getMontant(), 
			primesIndicesRepo.findByGroupeAndIndemniteLikeIgnoreCase(primesIndices.getGroupe(), "%publique").get(0).getMontant(),  
			computedPrimes, 
			roundUp(computedPrimes),
			getNumberOfMonths(primesGrade.getStartDate(), primesGrade.getEndDate()),
			getComputedPrimesGrade(primesGrade), 
			getComputedPrimesIndices(primesIndices)
		);
		return primesEdsdRepo.save(primesEdsd);
	}
}
