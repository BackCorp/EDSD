package com.edsd.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

@Entity
@Component
@Table(name = "non_logement_edsd", catalog = "edsd", uniqueConstraints = 
@UniqueConstraint(columnNames = {"non_logement_id"}))
public class NonLogementEdsd {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "non_logement_id", updatable = false, nullable = false)
    @NotNull(message="User ID is required")
	private int nonLogementEdsdId;
	
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
	
    @Column(name = "salaire_de_base", nullable = false)
    private double salaireDeBase;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="requester_id", nullable = false)
	private Requester belongsToRequester;
	
	@NotNull(message="The field createdby is required")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by_user_id")
	@JsonBackReference 
	private User createdBy;
	
	@Column(name = "computed_non_logement", nullable = false)
	private double computedNonLogement;
	
	@Column(name = "actual_non_logement", nullable = false)
	private int actualNonLogement;
	
    @Column(name = "number_of_months", nullable = false)
	private double numberOfMonths;


	public NonLogementEdsd() {}


	public NonLogementEdsd(User createdBy, Requester belongsToRequester, 
			Date startDate, Date endDate, double salaireDeBase, double computedNonLogement, 
			int actualNonLogement, double numberOfMonths) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.salaireDeBase = salaireDeBase;
		this.belongsToRequester = belongsToRequester;
		this.createdBy = createdBy;
		this.computedNonLogement = computedNonLogement;
		this.actualNonLogement = actualNonLogement;
		this.numberOfMonths = numberOfMonths;
	}


	public int getNonLogementEdsdId() {
		return nonLogementEdsdId;
	}


	public void setNonLogementEdsdId(int nonLogementEdsdId) {
		this.nonLogementEdsdId = nonLogementEdsdId;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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


	public double getSalaireDeBase() {
		return salaireDeBase;
	}


	public void setSalaireDeBase(double salaireDeBase) {
		this.salaireDeBase = salaireDeBase;
	}


	public Requester getBelongsToRequester() {
		return belongsToRequester;
	}


	public void setBelongsToRequester(Requester belongsToRequester) {
		this.belongsToRequester = belongsToRequester;
	}


	public User getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}


	public double getComputedNonLogement() {
		return computedNonLogement;
	}


	public void setComputedNonLogement(double computedNonLogement) {
		this.computedNonLogement = computedNonLogement;
	}


	public int getActualNonLogement() {
		return actualNonLogement;
	}


	public void setActualNonLogement(int actualNonLogement) {
		this.actualNonLogement = actualNonLogement;
	}


	public double getNumberOfMonths() {
		return numberOfMonths;
	}


	public void setNumberOfMonths(double numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}

	@Override
	public String toString() {
		return "NonLogementEdsd [nonLogementEdsdId=" + nonLogementEdsdId + ", createdDate=" + createdDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", salaireDeBase=" + salaireDeBase
				+ ", belongsToRequester=" + belongsToRequester + ", createdBy=" + createdBy + ", computedNonLogement="
				+ computedNonLogement + ", actualNonLogement=" + actualNonLogement + ", numberOfMonths="
				+ numberOfMonths + "]";
	}
		
}
