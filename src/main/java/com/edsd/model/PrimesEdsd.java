package com.edsd.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "primes_edsd", catalog = "edsd", uniqueConstraints = 
@UniqueConstraint(columnNames = {"primes_edsd_id"}))
public class PrimesEdsd {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "primes_edsd_id")
    @NotNull(message="User ID is required")
	private int primesEdsdId;
	
	@NotBlank
	@CreatedDate
	private DateTime createdDate;
	
	@NotBlank
	@NotNull(message="The field created by is required")
	@CreatedBy
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User createdBy;
	
	@NotBlank
    @Column(name = "start_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar startDate; 
	
	@NotBlank
    @Column(name = "end_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar endDate; 
	
	@NotBlank
    @Column(name = "grade", nullable = false)
    @Size(min=1, max=100)
    private String grade;
	
	@NotBlank
    @Column(name = "classe_liee_au_grade", nullable = false)
    @Size(min=1, max=100)
    private String classeLieeAuGrade;
	
	@NotBlank
    @Column(name = "indemnite_liee_au_grade", nullable = false)
    @Size(min=1, max=100)
    private String indemniteLieeAuGrade;
	
	@NotBlank
    @Column(name = "groupe", nullable = false)
    @Size(min=1, max=100)
    private String groupe;
	
	@NotBlank
    @Column(name = "classe_liee_aux_indices", nullable = false)
    @Size(min=1, max=100)
    private String classeLieeAuxIndices;
	
	@NotBlank
    @Column(name = "indemnite_liee_aux_indices", nullable = false)
    @Size(min=1, max=100)
    private String indemniteLieeAuxIndices;
	
	@NotBlank
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="requester_id", nullable = false)
	private Requester belongsToRequester;
	
	@NotBlank
	@Column(name = "primes_totales", nullable = false)
	private double primesTotales;

	public PrimesEdsd(DateTime createdDate, User createdBy, Requester belongsToRequester,
			Calendar startDate, Calendar endDate, String grade, String classeLieeAuGrade, String indemniteLieeAuGrade,
			String groupe, String classeLieeAuxIndices, String indemniteLieeAuxIndices, double primesTotales) {
		super();
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.belongsToRequester = belongsToRequester;
		this.startDate = startDate;
		this.endDate = endDate;
		this.grade = grade;
		this.classeLieeAuGrade = classeLieeAuGrade;
		this.indemniteLieeAuGrade = indemniteLieeAuGrade;
		this.groupe = groupe;
		this.classeLieeAuxIndices = classeLieeAuxIndices;
		this.indemniteLieeAuxIndices = indemniteLieeAuxIndices;
		this.primesTotales = primesTotales;
	}

	public int getPrimesEdsdId() {
		return primesEdsdId;
	}

	public void setPrimesEdsdId(int primesEdsdId) {
		this.primesEdsdId = primesEdsdId;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Requester getBelongsToRequester() {
		return belongsToRequester;
	}

	public void setBelongsToRequester(Requester belongsToRequester) {
		this.belongsToRequester = belongsToRequester;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
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

	public String getIndemniteLieeAuGrade() {
		return indemniteLieeAuGrade;
	}

	public void setIndemniteLieeAuGrade(String indemniteLieeAuGrade) {
		this.indemniteLieeAuGrade = indemniteLieeAuGrade;
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

	public String getIndemniteLieeAuxIndices() {
		return indemniteLieeAuxIndices;
	}

	public void setIndemniteLieeAuxIndices(String indemniteLieeAuxIndices) {
		this.indemniteLieeAuxIndices = indemniteLieeAuxIndices;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public double getPrimesTotales() {
		return primesTotales;
	}

	public void setPrimesTotales(double primesTotales) {
		this.primesTotales = primesTotales;
	}

	
}
