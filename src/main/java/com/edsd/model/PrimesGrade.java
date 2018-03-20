package com.edsd.model;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class PrimesGrade {
	
	private String classe;
	private Date startDate;
	private Date endDate;
	private String indemnite;
	private String grade;
	
	
	public PrimesGrade() {
		
	}
	
	public PrimesGrade(String classe, Date startDate, Date endDate, String indemnite, String grade) {
		super();
		this.classe = classe;
		this.startDate = startDate;
		this.endDate = endDate;
		this.indemnite = indemnite;
		this.grade = grade;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "PrimesGrade [classe=" + classe + ", startDate=" + startDate + ", endDate=" + endDate + ", indemnite="
				+ indemnite + ", grade=" + grade + "]";
	}
	
	

}
