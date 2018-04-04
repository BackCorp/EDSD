package com.edsd.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class NonLogement {

	private double salaireDeBase;
	private Date startDate;
	private Date endDate;
	
	public NonLogement() {}

	public NonLogement(double salaireDeBase, Date startDate, Date endDate) {
		super();
		this.salaireDeBase = salaireDeBase;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public double getSalaireDeBase() {
		return salaireDeBase;
	}

	public void setSalaireDeBase(double salaireDeBase) {
		this.salaireDeBase = salaireDeBase;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "NonLogement [salaireDeBase=" + salaireDeBase + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}
	
}
