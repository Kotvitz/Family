package com.example.familyapp.model;

public class Family {
	private Long id;
	private String familyName;
	private int nrOfInfants;
	private int nrOfChildren;
	private int nrOfAdults;
	
	public Family() {
		
	}
	
	public Family(Long id, String familyName, int nrOfInfants, int nrOfChildren, int nrOfAdults) {
		this.setId(id);
		this.setFamilyName(familyName);
		this.setNrOfInfants(nrOfInfants);
		this.setNrOfChildren(nrOfChildren);
		this.setNrOfAdults(nrOfAdults);
	}

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
