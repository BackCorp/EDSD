package com.edsd.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestHolder {

	@Autowired
	private PrimesGrade primesGrade;
	@Autowired
	private PrimesIndices primesIndices;
	@Autowired
	private NonLogement nonLogement;
	@Autowired
	private RappelsSalaires rappelsSalaires;
	
	private double retenues;
	private String requesterAccountNumber;
	
	public RequestHolder() {}
	

	public RequestHolder(PrimesGrade primesGrade, PrimesIndices primesIndices, NonLogement nonLogement,
			RappelsSalaires rappelsSalaires, double retenues, String requesterAccountNumber) {
		super();
		this.primesGrade = primesGrade;
		this.primesIndices = primesIndices;
		this.nonLogement = nonLogement;
		this.rappelsSalaires = rappelsSalaires;
		this.retenues = retenues;
		this.requesterAccountNumber = requesterAccountNumber;
	}

	public PrimesGrade getPrimesGrade() {
		return primesGrade;
	}
	public void setPrimesGrade(PrimesGrade primesGrade) {
		this.primesGrade = primesGrade;
	}
	public PrimesIndices getPrimesIndices() {
		return primesIndices;
	}
	public void setPrimesIndices(PrimesIndices primesIndices) {
		this.primesIndices = primesIndices;
	}
	
	public NonLogement getNonLogement() {
		return nonLogement;
	}

	public void setNonLogement(NonLogement nonLogement) {
		this.nonLogement = nonLogement;
	}

	public RappelsSalaires getRappelsSalaires() {
		return rappelsSalaires;
	}

	public void setRappelsSalaires(RappelsSalaires rappelsSalaires) {
		this.rappelsSalaires = rappelsSalaires;
	}

	public String getRequesterAccountNumber() {
		return requesterAccountNumber;
	}
	
	public void setRequesterAccountNumber(String requesterAccountNumber) {
		this.requesterAccountNumber = requesterAccountNumber;
	}


	public double getRetenues() {
		return retenues;
	}

	public void setRetenues(double retenues) {
		this.retenues = retenues;
	}


	@Override
	public String toString() {
		return "RequestHolder [primesGrade=" + primesGrade + ", primesIndices=" + primesIndices + ", nonLogement="
				+ nonLogement + ", rappelsSalaires=" + rappelsSalaires + ", retenues=" + retenues
				+ ", requesterAccountNumber=" + requesterAccountNumber + "]";
	}
	
	
}
