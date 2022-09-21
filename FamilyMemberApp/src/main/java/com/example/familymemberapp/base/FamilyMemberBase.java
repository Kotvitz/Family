package com.example.familymemberapp.base;

import javax.persistence.*;

@Entity
@Table(name = "familyMember")
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
}
