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
@Table(name = "rappels_salaires_edsd", catalog = "edsd", uniqueConstraints = 
@UniqueConstraint(columnNames = {"rappels_salaires_id"}))
public class RappelsSalairesEdsd {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rappels_salaires_id", updatable = false, nullable = false)
    @NotNull(message="User ID is required")
	private int rappelsSalairesId;
	
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
	
	@Column(name = "computed_rappels_salaires", nullable = false)
	private double computedRappelsSalaires;
	
	@Column(name = "actual_rappels_salaires", nullable = false)
	private int actualRappelsSalaires;
	
    @Column(name = "number_of_months", nullable = false)
	private double numberOfMonths;


	public RappelsSalairesEdsd() {}
	

	public RappelsSalairesEdsd(Date startDate, Date endDate, double salaireDeBase, Requester belongsToRequester,
			User createdBy, double computedRappelsSalaires, int actualRappelsSalaires, double numberOfMonths) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.salaireDeBase = salaireDeBase;
		this.belongsToRequester = belongsToRequester;
		this.createdBy = createdBy;
		this.computedRappelsSalaires = computedRappelsSalaires;
		this.actualRappelsSalaires = actualRappelsSalaires;
		this.numberOfMonths = numberOfMonths;
	}


	public int getRappelsSalairesId() {
		return rappelsSalairesId;
	}
	public void setRappelsSalairesId(int rappelsSalairesId) {
		this.rappelsSalairesId = rappelsSalairesId;
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

	public double getComputedRappelsSalaires() {
		return computedRappelsSalaires;
	}
	public void setComputedRappelsSalaires(double computedRappelsSalaires) {
		this.computedRappelsSalaires = computedRappelsSalaires;
	}

	public int getActualRappelsSalaires() {
		return actualRappelsSalaires;
	}
	public void setActualRappelsSalaires(int actualRappelsSalaires) {
		this.actualRappelsSalaires = actualRappelsSalaires;
	}

	public double getNumberOfMonths() {
		return numberOfMonths;
	}
	public void setNumberOfMonths(double numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}

	@Override
	public String toString() {
		return "RappelsSalairesEdsd [rappelsSalairesId=" + rappelsSalairesId + ", createdDate=" + createdDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", salaireDeBase=" + salaireDeBase
				+ ", belongsToRequester=" + belongsToRequester + ", createdBy=" + createdBy
				+ ", computedRappelsSalaires=" + computedRappelsSalaires + ", actualRappelsSalaires="
				+ actualRappelsSalaires + ", numberOfMonths=" + numberOfMonths + "]";
	}

}
