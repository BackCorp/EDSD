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
@Table(name = "primes_liees_aux_indices", catalog = "heroku_5889aeb3caa53dd", uniqueConstraints = 
@UniqueConstraint(columnNames = {"id", "groupe"}))
public class PrimesLieesAuxIndices {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull(message="Primes/Bonus ID is required")
	private int id;
	
	@NotBlank
    @Column(name = "groupe", nullable = false)
    @Size(min=1, max=100)
	private String groupe;
	
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
	
	
	public PrimesLieesAuxIndices() {
		
	}
	
	public PrimesLieesAuxIndices(String groupe, String classe, String indemnite, double montant, String observations) {
		super();
		this.groupe = groupe;
		this.classe = classe;
		this.indemnite = indemnite;
		this.montant = montant;
		this.observations = observations;
	}
	
	
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	public String getClasses() {
		return classe;
	}
	public void setClasses(String classes) {
		this.classe = classes;
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
		return "PrimesLieesAuxIndices [id=" + id + ", groupe=" + groupe + ", classe=" + classe + ", indemnite="
				+ indemnite + ", montant=" + montant + ", observations=" + observations + "]";
	}
	
}
