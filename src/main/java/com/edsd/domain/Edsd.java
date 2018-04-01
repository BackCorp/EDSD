package com.edsd.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.edsd.config.DuplicateEdsdNotAllowException;
//import com.edsd.Controllers.ErrorResponse;
import com.edsd.model.NonLogement;
import com.edsd.model.NonLogementEdsd;
import com.edsd.model.PrimesEdsd;
import com.edsd.model.PrimesGrade;
import com.edsd.model.PrimesIndices;
import com.edsd.model.PrimesLieesAuxIndices;
import com.edsd.model.RappelsSalaires;
import com.edsd.model.RappelsSalairesEdsd;
import com.edsd.model.Requester;
import com.edsd.model.User;
import com.edsd.repository.NonLogementEdsdRepository;
import com.edsd.repository.PrimesEdsdRepository;
import com.edsd.repository.PrimesLieesAuGadeOuCategorieRepository;
import com.edsd.repository.PrimesLieesAuxIndicesRepository;
import com.edsd.repository.RappelsSalairesEdsdRepository;

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
	private NonLogementEdsdRepository nonLogementEdsdRepo;
	@Autowired
	private RappelsSalairesEdsdRepository rappelsSalairesEdsdRepo;
	
	
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
	
	private int getRoundUp(double number) {
		return (int)Math.round(number);
	}
	
	private double getComputedRetenues(double numberOfMonths, double montantRetenues) {
		return numberOfMonths * montantRetenues;
	}
	
	public PrimesEdsd createPrimesEdsd(User createdBy, Requester requester, PrimesIndices primesIndices, 
			PrimesGrade primesGrade, double retenues) {
		
		if(primesEdsdRepo.findByStartDateAndEndDateAndBelongsToRequester(
				primesGrade.getStartDate(), primesGrade.getEndDate(), requester).isEmpty()) {
			
			double computedPrimes = getComputedPrimes(primesIndices, primesGrade, retenues);
			PrimesEdsd primesEdsd = new PrimesEdsd(
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
				getRoundUp(computedPrimes),
				getNumberOfMonths(primesGrade.getStartDate(), primesGrade.getEndDate()),
				getComputedPrimesGrade(primesGrade), 
				getComputedPrimesIndices(primesIndices)
			);
			return primesEdsdRepo.save(primesEdsd);
		} else {
			throw new DuplicateEdsdNotAllowException (
				"Primes EDSD: Requester with matricule " + requester.getAccountNumber() + 
				" has submitted a request for period " + primesGrade.getStartDate() + 
				" to " + primesGrade.getEndDate() + " already.");
		}
	}

	private double getComputedNonLogement(NonLogement nonLogement) {
		return nonLogement.getSalaireDeBase() * getNumberOfMonths(nonLogement.getStartDate(), nonLogement.getEndDate()) * (20/100.0);
	}
	
	public NonLogementEdsd createNonLogement(User createdBy, Requester requester, NonLogement nonLogement) {
		if(nonLogementEdsdRepo.findByStartDateAndEndDateAndBelongsToRequester(
				nonLogement.getStartDate(), nonLogement.getEndDate(), requester).isEmpty()) {
			double computedNonLogement = getComputedNonLogement(nonLogement);
			NonLogementEdsd nonLogementEdsd = new NonLogementEdsd(
				createdBy, 
				requester, 
				nonLogement.getStartDate(), 
				nonLogement.getEndDate(), 
				nonLogement.getSalaireDeBase(), 
				computedNonLogement,
				getRoundUp(computedNonLogement), 
				getNumberOfMonths(nonLogement.getStartDate(), nonLogement.getEndDate())
			);
			return nonLogementEdsdRepo.save(nonLogementEdsd);
		} else {
			throw new DuplicateEdsdNotAllowException (
				"Non logement EDSD: Requester with matricule " + requester.getAccountNumber() + 
				" has submitted a request for period " + nonLogement.getStartDate() + 
				" to " + nonLogement.getEndDate() + " already.");
		}
	}

	private double getComputedRappelsSalaires(RappelsSalaires rappelsSalaires) {
		return rappelsSalaires.getSalaireDeBase() * getNumberOfMonths(rappelsSalaires.getStartDate(), rappelsSalaires.getEndDate());
	}
	
	public RappelsSalairesEdsd createRappelsSalaires(User createdBy, Requester requester, RappelsSalaires rappelsSalaires) {
		if(rappelsSalairesEdsdRepo.findByStartDateAndEndDateAndBelongsToRequester(
				rappelsSalaires.getStartDate(), rappelsSalaires.getEndDate(), requester).isEmpty()) {
			double computedRappelsSalaires = getComputedRappelsSalaires(rappelsSalaires);
			RappelsSalairesEdsd rappelsSalairesEdsd = new RappelsSalairesEdsd(
				rappelsSalaires.getStartDate(), 
				rappelsSalaires.getEndDate(), 
				rappelsSalaires.getSalaireDeBase(), 
				requester, 
				createdBy, 
				computedRappelsSalaires,
				getRoundUp(computedRappelsSalaires), 
				getNumberOfMonths(rappelsSalaires.getStartDate(), rappelsSalaires.getEndDate())
			);
			return rappelsSalairesEdsdRepo.save(rappelsSalairesEdsd);
		} else {
			throw new DuplicateEdsdNotAllowException (
				"Rappels Salaires EDSD: Requester with matricule " + requester.getAccountNumber() + 
				" has submitted a request for period " + rappelsSalaires.getStartDate() + 
				" to " + rappelsSalaires.getEndDate() + " already.");
		}
		
	}

}