package com.example.familyapp.model;

import java.util.List;

import com.example.familymemberapp.model.FamilyMember;

public class Family {
	private Long id;
	private String familyName;
	private int nrOfInfants;
	private int nrOfChildren;
	private int nrOfAdults;
	private List<FamilyMember> familyMemberList;
	
	public Family() {
		
	}
	
	public Family(Long id, String familyName, int nrOfInfants, int nrOfChildren, int nrOfAdults, List<FamilyMember> familyMemberList) {
		this.setId(id);
		this.setFamilyName(familyName);
		this.setNrOfInfants(nrOfInfants);
		this.setNrOfChildren(nrOfChildren);
		this.setNrOfAdults(nrOfAdults);
		this.setFamilyMemberList(familyMemberList);
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

	public List<FamilyMember> getFamilyMemberList() {
		return familyMemberList;
	}

	public void setFamilyMemberList(List<FamilyMember> familyMemberList) {
		this.familyMemberList = familyMemberList;
	}
}
