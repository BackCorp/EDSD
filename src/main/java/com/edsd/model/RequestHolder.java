package com.edsd.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestHolder {

	@Autowired
	private PrimesGrade primesGrade;
	@Autowired
	private PrimesIndices primesIndices;
	
	
	public RequestHolder() {
		
	}
	
	public RequestHolder(PrimesGrade primesGrade, PrimesIndices primesIndices) {
		super();
		this.primesGrade = primesGrade;
		this.primesIndices = primesIndices;
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
	
	
	
}
