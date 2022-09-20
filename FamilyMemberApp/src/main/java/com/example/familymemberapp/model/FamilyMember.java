package com.example.familymemberapp.model;

public class FamilyMember {
	private Long familyId;
	private String familyName;
	private String givenName;
	private int age;

	public FamilyMember() {

	}

	public FamilyMember(Long familyId, String familyName, String givenName, int age) {
		this.setFamilyId(familyId);
		this.setFamilyName(familyName);
		this.setGivenName(givenName);
		this.setAge(age);
	}

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
