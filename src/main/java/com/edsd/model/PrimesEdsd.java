package com.edsd.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
@UniqueConstraint(columnNames = {"primes_edsd_id", "requester_id"}))
public class PrimesEdsd {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "primes_edsd_id", updatable = false, nullable = false)
    @NotNull(message="User ID is required")
	private int primesEdsdId;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Calendar createdDate;
	
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
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="requester_id", nullable = false)
	private Requester belongsToRequester;
	
	@NotNull(message="The field created by is required")
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by_user_id")
	@JsonBackReference 
	private User createdBy;
	
	@Column(name = "computed_primes", nullable = false)
	private double computedPrimes;
	
    @Column(name = "number_of_primes_months", nullable = false)
	private double numberOfPrimesMonths;
	
    @Column(name = "computed_primes_grade", nullable = false)
	private double computedPrimesGrade;

    @Column(name = "computed_primes_indices", nullable = false)
	private double computedPrimesIndices;


    
	public PrimesEdsd() {}
	
	public PrimesEdsd(
			User createdBy,
			Requester belongsToRequester, Date startDate, Date endDate, 
			String grade, String classeLieeAuGrade, double indemniteLieeAuGradeTechnicite,
			String groupe, String classeLieeAuxIndices, double indemniteLieeAuxIndicesAstreinte, 
			double indemniteLieeAuxIndicesSantePublique, double computedPrimes, double numberOfPrimesMonths,
			double computedPrimesGrade, double computedPrimesIndices
		) {
		super();
//		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.belongsToRequester = belongsToRequester;
		this.startDate = startDate;
		this.endDate = endDate;
		this.grade = grade;
		this.classeLieeAuGrade = classeLieeAuGrade;
		this.indemniteLieeAuGradeTechnicite = indemniteLieeAuGradeTechnicite;
		this.groupe = groupe;
		this.classeLieeAuxIndices = classeLieeAuxIndices;
		this.indemniteLieeAuxIndicesAstreinte = indemniteLieeAuxIndicesAstreinte;
		this.indemniteLieeAuxIndicesSantePublique = indemniteLieeAuxIndicesSantePublique;
		this.computedPrimes = computedPrimes;
		this.numberOfPrimesMonths = numberOfPrimesMonths;
		this.computedPrimesGrade = computedPrimesGrade;
		this.computedPrimesIndices = computedPrimesIndices;
	}

	public int getPrimesEdsdId() {
		return primesEdsdId;
	}

	public void setPrimesEdsdId(int primesEdsdId) {
		this.primesEdsdId = primesEdsdId;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
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

	public double getNumberOfPrimesMonths() {
		return numberOfPrimesMonths;
	}

	public void setNumberOfPrimesMonths(double numberOfPrimesMonths) {
		this.numberOfPrimesMonths = numberOfPrimesMonths;
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
