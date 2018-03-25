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
	
	private double computedPrimesGrade;
	private double computedPrimesIndices;
	private double computedPrimes;
	private double primesGradeTecniciteMontant;
	private double primesIndicesAstreinteMontant;
	private double primesIndicesSantePubliqueMontant;
	private double primesIndicesMontant;
	private double numberOfPrimesMonths;
	private final double TAX_PERCENTAGE = 5.28/100;
	private final int HOUR = 3600000;
	
	public Edsd() {}
	
	
	public Edsd(double computedPrimesGrade, double computedPrimesIndices) {
		super();
		this.computedPrimesGrade = computedPrimesGrade;
		this.computedPrimesIndices = computedPrimesIndices;
	}

	
	private void setNumberOfPrimesMonths(PrimesIndices primesIndices) {
		System.out.println(primesIndices.getEndDate().getTime());
		System.out.println(primesIndices.getStartDate().getTime());
		this.numberOfPrimesMonths = (primesIndices.getEndDate().getTime() - primesIndices.getStartDate().getTime() + HOUR)/(3600*1000*24*30.0);
	}
	
	private void setNumberOfPrimesMonths(PrimesGrade primesGrade) {
		this.numberOfPrimesMonths = (primesGrade.getEndDate().getTime() - primesGrade.getStartDate().getTime() + HOUR)/(3600*1000*24*30.0);
	}
	
	private double getNumberOfPrimesMonths() {
		return numberOfPrimesMonths;
	}
	
	private void setPrimesGradeTecniciteMontant(PrimesGrade primesGrade) {
		this.primesGradeTecniciteMontant = primesGradeRepo.findByGradeOuCategorieAndClasseIgnoreCase(primesGrade.getGrade(), primesGrade.getClasse()).getMontant();
	}
	
	private double getPrimesGradeTecniciteMontant() {
		return primesGradeTecniciteMontant;
	}
	
	private void setPrimesIndicesMontant(PrimesIndices primesIndices) {
		List<PrimesLieesAuxIndices> primeLieesAuxIndices = primesIndicesRepo.findByGroupeAndClasseIgnoreCase(primesIndices.getGroupe(), primesIndices.getClasse());
		primeLieesAuxIndices.forEach(primeLieesAuxIndice -> {
			if(primeLieesAuxIndice.getIndemnite().equalsIgnoreCase("astreinte")) {
				primesIndicesAstreinteMontant = primeLieesAuxIndice.getMontant();
			} else {
				primesIndicesSantePubliqueMontant = primeLieesAuxIndice.getMontant();
			}
		});
		primesIndicesMontant = primesIndicesAstreinteMontant + primesIndicesSantePubliqueMontant;
	}
	
	private double getPrimesIndicesMontant() {
		return primesIndicesMontant;
	}

	private double getComputedPrimesGrade(PrimesGrade primesGrade) {
		this.setPrimesGradeTecniciteMontant(primesGrade);
		this.setNumberOfPrimesMonths(primesGrade);
		return computedPrimesGrade = this.getPrimesGradeTecniciteMontant() * (1 - TAX_PERCENTAGE) * this.getNumberOfPrimesMonths();
	}
	
	private double getComputedPrimesIndices(PrimesIndices primesIndices) {
		this.setPrimesIndicesMontant(primesIndices);
		this.setNumberOfPrimesMonths(primesIndices);
		return computedPrimesIndices = this.getPrimesIndicesMontant() * (1 - TAX_PERCENTAGE) * this.getNumberOfPrimesMonths();
	}

	private void setComputedPrimes(PrimesIndices primesIndices, PrimesGrade primesGrade) {
		computedPrimes = this.getComputedPrimesIndices(primesIndices)  + this.getComputedPrimesGrade(primesGrade) ;
	}
	
	private double getComputedPrimes() {
		return computedPrimes;
	}
	
	public PrimesEdsd getPrimesEdsd(PrimesIndices primesIndices, PrimesGrade primesGrade, Principal principal, Requester requester) {
		this.setComputedPrimes(primesIndices, primesGrade);
		User user = usersRepo.findByUsername(principal.getName()).get();
		
		primesEdsd = new PrimesEdsd(user,
			requester, primesGrade.getStartDate(), primesIndices.getEndDate(), 
			primesGrade.getGrade(), primesGrade.getClasse(), this.getPrimesGradeTecniciteMontant(),
			primesIndices.getGroupe(), primesIndices.getClasse(), this.primesIndicesAstreinteMontant, 
			this.primesIndicesSantePubliqueMontant, this.getComputedPrimes(), this.getNumberOfPrimesMonths(),
			this.getComputedPrimesGrade(primesGrade), this.getComputedPrimesIndices(primesIndices)
		);
		return primesEdsdRepo.save(primesEdsd);
	}
}
