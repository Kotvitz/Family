package com.example.familyapp.model;

import javax.persistence.*;

@Entity
@Table(name = "family")
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
	
}
