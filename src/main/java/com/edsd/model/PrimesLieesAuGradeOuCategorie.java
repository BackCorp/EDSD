package com.edsd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "primes_liees_au_grade_ou_categorie", catalog = "edsd", uniqueConstraints = 
@UniqueConstraint(columnNames = {"id"}))
public class PrimesLieesAuGradeOuCategorie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull(message="Primes/Bonus ID is required")
	private int id;
	
	@NotBlank
    @Column(name = "grade_ou_categorie", nullable = false)
    @Size(min=1, max=100)
	private String gradeOuCategorie;
	
	@NotBlank
    @Column(name = "classe", nullable = false)
    @Size(min=1, max=100)
	private String classe;
	
	@NotBlank
    @Column(name = "indemnite", nullable = false)
    @Size(min=1, max=100)
	private String indemnite;
	
	@NotBlank
    @Column(name = "montant", nullable = false)
	private double montant;
	
	@NotBlank
    @Column(name = "observations", nullable = false)
    @Size(min=1, max=100)
	private String observations;

	
	public PrimesLieesAuGradeOuCategorie() {
		
	}
	
	public PrimesLieesAuGradeOuCategorie(String gradeOuCategorie, String classe, String indemnite,
			double montant, String observations) {
		super();
		this.gradeOuCategorie = gradeOuCategorie;
		this.classe = classe;
		this.indemnite = indemnite;
		this.montant = montant;
		this.observations = observations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGradeOuCategorie() {
		return gradeOuCategorie;
	}

	public void setGradeOuCategorie(String gradeOuCategorie) {
		this.gradeOuCategorie = gradeOuCategorie;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getIndemnite() {
		return indemnite;
	}

	public void setIndemnite(String indemnite) {
		this.indemnite = indemnite;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	@Override
	public String toString() {
		return "PrimesLieesAuGradeOuCategorie [id=" + id + ", gradeOuCategorie=" + gradeOuCategorie + ", classe="
				+ classe + ", indemnite=" + indemnite + ", montant=" + montant + ", observations=" + observations + "]";
	}
	
	
	
}
