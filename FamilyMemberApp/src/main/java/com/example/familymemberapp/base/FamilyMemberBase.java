package com.example.familymemberapp.base;

import javax.persistence.*;

import com.example.familymemberapp.model.FamilyMember;

@Entity
@Table(schema = "familymemberdb", name = "familyMember")
public class FamilyMemberBase {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Column(name = "familyId")
    private Long familyId;

    @Column(name = "familyName", length = 255)
    private String familyName;

    @Column(name = "givenName", length = 255)
    private String givenName;

    @Column (name = "age")
    private int age;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
    public FamilyMember copyFromBaseToFamilyMemberModel(){
        FamilyMember familyMember = new FamilyMember();
        familyMember.setFamilyName(getFamilyName());
        familyMember.setAge(getAge());
        familyMember.setGivenName(getGivenName());
        return familyMember;
    }
}
