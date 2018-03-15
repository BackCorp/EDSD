package com.edsd.model;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "requester", catalog = "edsd", uniqueConstraints = 
@UniqueConstraint(columnNames = {"requester_id", "account_number"}))
public class Requester {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "requester_id")
    @NotNull(message="Requestor ID is required")
	private int requesterId;
	
	@NotBlank
    @Column(name = "account_number", nullable = false)
    @Size(min=1, max=100)
	private String accountNumber; 	// Matricule
	
	@NotBlank
    @Column(name = "last_name", nullable = false)
    @Size(min=1, max=100)
	private String lastName;
	
	@NotBlank
    @Column(name = "first_name", nullable = false)
    @Size(min=1, max=100)
	private String firstName;
	
	@NotBlank
    @Column(name = "region", nullable = false)
    @Size(min=1, max=100)
	private String region;
	
	@NotBlank
    @Column(name = "health_district", nullable = false)
    @Size(min=1, max=100)
	private String healthDistrict;
	
	@NotBlank
    @Column(name = "structure", nullable = false)
    @Size(min=1, max=100)
	private String structure;
	
	@NotBlank
    @Column(name = "genre", nullable = false)
    @Size(min=1, max=100)
	private String genre;
	
	@NotBlank
    @Column(name = "dob", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dob;
	
	@NotBlank
    @Column(name = "place_of_birth", nullable = false)
    @Size(min=1, max=100)
	private String placeOfBirth;
	
	@NotBlank
    @Column(name = "status", nullable = false)
    @Size(min=1, max=100)
	private String status;
	
	@NotBlank
    @Column(name = "field_of_work", nullable = false)
    @Size(min=1, max=100)
	private String fieldOfWork;
	
    @Column(name = "recruitment_date", nullable = true)
	@Temporal(TemporalType.DATE)
	private Calendar recruitmentDate;
	
	@NotBlank
    @Column(name = "grade_at_recruitment", nullable = false)
    @Size(min=1, max=100)
	private String gradeAtRecruitment;
	
	@NotBlank
    @Column(name = "current_grade", nullable = false)
    @Size(min=1, max=100)
	private String currentGrade;
	
    @Column(name = "category_at_recruitment", nullable = true)
    @Size(min=1, max=100)
	private String categoryAtRecruitment;
	
	@NotBlank
    @Column(name = "current_category", nullable = false)
    @Size(min=1, max=100)
	private String currentCategory;
	
	@NotBlank
    @Column(name = "current_index", nullable = false)
    @Size(min=1, max=100)
	private int currentIndex;
	
	@NotBlank
    @Column(name = "current_situation", nullable = false)
    @Size(min=1, max=100)
	private String currentSituation;
	
    @Column(name = "rank_position", nullable = true)
    @Size(min=1, max=100)
	private String rankPosition;
	
    @Column(name = "occupied_organic_position", nullable = true)
    @Size(min=1, max=100)
	private String occupiedOrganicPosition;
	
    @Column(name = "date_of_appointment_or_assignment", nullable = true)
	@Temporal(TemporalType.DATE)
	private Calendar dateOfAppointmentOrAssignment;
	
	@NotBlank
    @Column(name = "appointment_type", nullable = false)
    @Size(min=1, max=100)
	private String appointmentType;
	
	@NotBlank
    @Column(name = "reference_appointment_or_assignment", nullable = false)
    @Size(min=1, max=100)
	private String referenceAppointmentOrAssignment;

	
	public Requester() {
		
	}
	
	public Requester(int requesterId, String accountNumber, String lastName, String firstName, String region,
			String healthDistrict, String structure, String genre, Calendar dob, String placeOfBirth, String status,
			String fieldOfWork, Calendar recruitmentDate, String gradeAtRecruitment, String currentGrade,
			String categoryAtRecruitment, String currentCategory, int currentIndex, String currentSituation,
			String rankPosition, String occupiedOrganicPosition, Calendar dateOfAppointmentOrAssignment,
			String appointmentType, String referenceAppointmentOrAssignment) {
		super();
		this.requesterId = requesterId;
		this.accountNumber = accountNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.region = region;
		this.healthDistrict = healthDistrict;
		this.structure = structure;
		this.genre = genre;
		this.dob = dob;
		this.placeOfBirth = placeOfBirth;
		this.status = status;
		this.fieldOfWork = fieldOfWork;
		this.recruitmentDate = recruitmentDate;
		this.gradeAtRecruitment = gradeAtRecruitment;
		this.currentGrade = currentGrade;
		this.categoryAtRecruitment = categoryAtRecruitment;
		this.currentCategory = currentCategory;
		this.currentIndex = currentIndex;
		this.currentSituation = currentSituation;
		this.rankPosition = rankPosition;
		this.occupiedOrganicPosition = occupiedOrganicPosition;
		this.dateOfAppointmentOrAssignment = dateOfAppointmentOrAssignment;
		this.appointmentType = appointmentType;
		this.referenceAppointmentOrAssignment = referenceAppointmentOrAssignment;
	}

	public int getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getHealthDistrict() {
		return healthDistrict;
	}

	public void setHealthDistrict(String healthDistrict) {
		this.healthDistrict = healthDistrict;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFieldOfWork() {
		return fieldOfWork;
	}

	public void setFieldOfWork(String fieldOfWork) {
		this.fieldOfWork = fieldOfWork;
	}
	
	public Calendar getRecruitmentDate() {
		return recruitmentDate;
	}

	public void setRecruitmentDate(Calendar recruitmentDate) {
		this.recruitmentDate = recruitmentDate;
	}

	public String getGradeAtRecruitment() {
		return gradeAtRecruitment;
	}

	public void setGradeAtRecruitment(String gradeAtRecruitment) {
		this.gradeAtRecruitment = gradeAtRecruitment;
	}

	public String getCurrentGrade() {
		return currentGrade;
	}

	public void setCurrentGrade(String currentGrade) {
		this.currentGrade = currentGrade;
	}

	public String getCategoryAtRecruitment() {
		return categoryAtRecruitment;
	}

	public void setCategoryAtRecruitment(String categoryAtRecruitment) {
		this.categoryAtRecruitment = categoryAtRecruitment;
	}

	public String getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(String currentCategory) {
		this.currentCategory = currentCategory;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public String getCurrentSituation() {
		return currentSituation;
	}

	public void setCurrentSituation(String currentSituation) {
		this.currentSituation = currentSituation;
	}

	public String getRankPosition() {
		return rankPosition;
	}

	public void setRankPosition(String rankPosition) {
		this.rankPosition = rankPosition;
	}

	public String getOccupiedOrganicPosition() {
		return occupiedOrganicPosition;
	}

	public void setOccupiedOrganicPosition(String occupiedOrganicPosition) {
		this.occupiedOrganicPosition = occupiedOrganicPosition;
	}

	public Calendar getDateOfAppointmentOrAssignment() {
		return dateOfAppointmentOrAssignment;
	}

	public void setDateOfAppointmentOrAssignment(Calendar dateOfAppointmentOrAssignment) {
		this.dateOfAppointmentOrAssignment = dateOfAppointmentOrAssignment;
	}

	public String getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}

	public String getReferenceAppointmentOrAssignment() {
		return referenceAppointmentOrAssignment;
	}

	public void setReferenceAppointmentOrAssignment(String referenceAppointmentOrAssignment) {
		this.referenceAppointmentOrAssignment = referenceAppointmentOrAssignment;
	}
	
	
	
}
