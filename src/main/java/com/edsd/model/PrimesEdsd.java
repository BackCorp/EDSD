package com.edsd.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Component
@Table(name = "primes_edsd", catalog = "edsd", uniqueConstraints = 
@UniqueConstraint(columnNames = {"primes_edsd_id"}))
public class PrimesEdsd {

//	private static final long serialVersionUID = 6686275444648247316L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "primes_edsd_id", updatable = false, nullable = false)
    @NotNull(message="User ID is required")
	private int primesEdsdId;
	
	@Column(name = "retenues", nullable = false, columnDefinition="DOUBLE default '0.00'")
	private double retenues;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date", 
		columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
		nullable = false)
	private Date createdDate;
	
    @Column(name = "start_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date startDate; 
	
    @Column(name = "end_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date endDate; 
	
	@NotBlank
    @Column(name = "grade", nullable = false)
    @Size(min=1, max=100)
    private String grade;
	
	@NotBlank
    @Column(name = "classe_liee_au_grade", nullable = false)
    @Size(min=1, max=100)
    private String classeLieeAuGrade;
	
    @Column(name = "indemnite_liee_au_grade_technicite", nullable = false)
    private double indemniteLieeAuGradeTechnicite;
	
	@NotBlank
    @Column(name = "groupe", nullable = false)
    @Size(min=1, max=100)
    private String groupe;
	
	@NotBlank
    @Column(name = "classe_liee_aux_indices", nullable = false)
    @Size(min=1, max=100)
    private String classeLieeAuxIndices;
	
    @Column(name = "indemnite_liee_aux_indices_astreinte", nullable = false)
    private double indemniteLieeAuxIndicesAstreinte;
	
	@Column(name = "indemnite_liee_aux_indices_sante_publique", nullable = false)
    private double indemniteLieeAuxIndicesSantePublique;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="requester_id", nullable = false)
	private Requester belongsToRequester;
	
	@CreatedBy
	@NotNull(message="The field createdby is required")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by_user_id")
	@JsonBackReference 
	private User createdBy;
	
	@Column(name = "computed_primes", nullable = false)
	private double computedPrimes;
	
	@Column(name = "actual_primes", nullable = false)
	private int actualPrimes;
	
    @Column(name = "number_of_months", nullable = false)
	private double numberOfMonths;
	
    @Column(name = "computed_primes_grade", nullable = false)
	private double computedPrimesGrade;

    @Column(name = "computed_primes_indices", nullable = false)
	private double computedPrimesIndices;


	public PrimesEdsd() {}
	

	public PrimesEdsd(
			User createdBy, Requester belongsToRequester, Date startDate, 
			Date endDate, String grade, String classeLieeAuGrade, 
			double indemniteLieeAuGradeTechnicite, String groupe, String classeLieeAuxIndices,
			double retenues, double indemniteLieeAuxIndicesAstreinte, 
			double indemniteLieeAuxIndicesSantePublique, double computedPrimes, int actualPrimes,
			double numberOfMonths, double computedPrimesGrade, double computedPrimesIndices) {
		super();
		this.retenues = retenues;
		this.startDate = startDate;
		this.endDate = endDate;
		this.grade = grade;
		this.classeLieeAuGrade = classeLieeAuGrade;
		this.indemniteLieeAuGradeTechnicite = indemniteLieeAuGradeTechnicite;
		this.groupe = groupe;
		this.classeLieeAuxIndices = classeLieeAuxIndices;
		this.indemniteLieeAuxIndicesAstreinte = indemniteLieeAuxIndicesAstreinte;
		this.indemniteLieeAuxIndicesSantePublique = indemniteLieeAuxIndicesSantePublique;
		this.belongsToRequester = belongsToRequester;
		this.createdBy = createdBy;
		this.computedPrimes = computedPrimes;
		this.actualPrimes = actualPrimes;
		this.numberOfMonths = numberOfMonths;
		this.computedPrimesGrade = computedPrimesGrade;
		this.computedPrimesIndices = computedPrimesIndices;
	}

	public PrimesEdsd(PrimesEdsd primesEdsd) {
		super();
		this.primesEdsdId = primesEdsd.getPrimesEdsdId();
		this.retenues = primesEdsd.getRetenues();
		this.startDate = primesEdsd.getStartDate();
		this.endDate = primesEdsd.getEndDate();
		this.grade = primesEdsd.getGrade();
		this.classeLieeAuGrade = primesEdsd.getClasseLieeAuGrade();
		this.indemniteLieeAuGradeTechnicite = primesEdsd.getIndemniteLieeAuGradeTechnicite();
		this.groupe = primesEdsd.getGroupe();
		this.classeLieeAuxIndices = primesEdsd.getClasseLieeAuxIndices();
		this.indemniteLieeAuxIndicesAstreinte = primesEdsd.getIndemniteLieeAuxIndicesAstreinte();
		this.indemniteLieeAuxIndicesSantePublique = primesEdsd.getIndemniteLieeAuxIndicesSantePublique();
		this.belongsToRequester = primesEdsd.getBelongsToRequester();
		this.createdBy = primesEdsd.getCreatedBy();
		this.computedPrimes = primesEdsd.getComputedPrimes();
		this.actualPrimes = primesEdsd.getActualPrimes();
		this.numberOfMonths = primesEdsd.getNumberOfMonths();
		this.computedPrimesGrade = primesEdsd.getComputedPrimesGrade();
		this.computedPrimesIndices = primesEdsd.getComputedPrimesIndices();
	}
	
	public int getPrimesEdsdId() {
		return primesEdsdId;
	}

	public void setPrimesEdsdId(int primesEdsdId) {
		this.primesEdsdId = primesEdsdId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Requester getBelongsToRequester() {
		return belongsToRequester;
	}

	public void setBelongsToRequester(Requester belongsToRequester) {
		this.belongsToRequester = belongsToRequester;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClasseLieeAuGrade() {
		return classeLieeAuGrade;
	}

	public void setClasseLieeAuGrade(String classeLieeAuGrade) {
		this.classeLieeAuGrade = classeLieeAuGrade;
	}

	public double getIndemniteLieeAuGradeTechnicite() {
		return indemniteLieeAuGradeTechnicite;
	}

	public void setIndemniteLieeAuGrade(double indemniteLieeAuGradeTechnicite) {
		this.indemniteLieeAuGradeTechnicite = indemniteLieeAuGradeTechnicite;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public String getClasseLieeAuxIndices() {
		return classeLieeAuxIndices;
	}

	public void setClasseLieeAuxIndices(String classeLieeAuxIndices) {
		this.classeLieeAuxIndices = classeLieeAuxIndices;
	}

	public double getIndemniteLieeAuxIndicesAstreinte() {
		return indemniteLieeAuxIndicesAstreinte;
	}

	public void setIndemniteLieeAuxIndicesAstreinte(double indemniteLieeAuxIndicesAstreinte) {
		this.indemniteLieeAuxIndicesAstreinte = indemniteLieeAuxIndicesAstreinte;
	}
	
	public double getIndemniteLieeAuxIndicesSantePublique() {
		return indemniteLieeAuxIndicesSantePublique;
	}

	public void setIndemniteLieeAuxIndicesSantePublique(double indemniteLieeAuxIndicesSantePublique) {
		this.indemniteLieeAuxIndicesSantePublique = indemniteLieeAuxIndicesSantePublique;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public double getComputedPrimes() {
		return computedPrimes;
	}

	public void setComputedPrimes(double computedPrimes) {
		this.computedPrimes = computedPrimes;
	}
	
	public double getRetenues() {
		return retenues;
	}
	public void setRetenues(double retenues) {
		this.retenues = retenues;
	}

	public int getActualPrimes() {
		return actualPrimes;
	}
	public void setActualPrimes(int actualPrimes) {
		this.actualPrimes = actualPrimes;
	}

	public double getNumberOfMonths() {
		return numberOfMonths;
	}
	public void setNumberOfMonths(double numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}

	public double getComputedPrimesGrade() {
		return computedPrimesGrade;
	}

	public void setComputedPrimesGrade(double computedPrimesGrade) {
		this.computedPrimesGrade = computedPrimesGrade;
	}

	public double getComputedPrimesIndices() {
		return computedPrimesIndices;
	}

	public void setComputedPrimesIndices(double computedPrimesIndices) {
		this.computedPrimesIndices = computedPrimesIndices;
	}

	public void setIndemniteLieeAuGradeTechnicite(double indemniteLieeAuGradeTechnicite) {
		this.indemniteLieeAuGradeTechnicite = indemniteLieeAuGradeTechnicite;
	}

	
}
