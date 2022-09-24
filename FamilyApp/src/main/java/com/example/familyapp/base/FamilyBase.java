package com.example.familyapp.base;

import javax.persistence.*;

@Entity
@Table(schema = "familydb", name = "family")
public class FamilyBase {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "familyName")
	private String familyName;
	
	@Column(name = "nrOfInfants")
	private int nrOfInfants;
	
	@Column(name = "nrOfChildren")
	private int nrOfChildren;
	
	@Column(name = "nrOfAdults")
	private int nrOfAdults;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public int getNrOfInfants() {
		return nrOfInfants;
	}

	public void setNrOfInfants(int nrOfInfants) {
		this.nrOfInfants = nrOfInfants;
	}

	public int getNrOfChildren() {
		return nrOfChildren;
	}

	public void setNrOfChildren(int nrOfChildren) {
		this.nrOfChildren = nrOfChildren;
	}

	public int getNrOfAdults() {
		return nrOfAdults;
	}

	public void setNrOfAdults(int nrOfAdults) {
		this.nrOfAdults = nrOfAdults;
	}
	
}
