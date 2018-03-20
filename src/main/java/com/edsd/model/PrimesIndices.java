package com.edsd.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class PrimesIndices {
	
	private String classe;
	private Date startDate;
	private Date endDate;
	private String indemnite;
	private String groupe;
	
	
	public PrimesIndices() {
		
	}

	public PrimesIndices(String classe, Date startDate, Date endDate, String indemnite, String groupe) {
		super();
		this.classe = classe;
		this.startDate = startDate;
		this.endDate = endDate;
		this.indemnite = indemnite;
		this.groupe = groupe;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
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

	public String getIndemnite() {
		return indemnite;
	}

	public void setIndemnite(String indemnite) {
		this.indemnite = indemnite;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	@Override
	public String toString() {
		return "PrimesIndices [classe=" + classe + ", startDate=" + startDate + ", endDate=" + endDate + ", indemnite="
				+ indemnite + ", groupe=" + groupe + "]";
	}
	
}
