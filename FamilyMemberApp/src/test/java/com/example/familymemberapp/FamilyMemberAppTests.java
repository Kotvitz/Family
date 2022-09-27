package com.example.familymemberapp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.familymemberapp.base.service.FamilyMemberBaseService;
import com.example.familymemberapp.model.FamilyMember;

@SpringBootTest
class FamilyMemberAppTests {

    @Mock
    EntityManager entityManager;
    
    @InjectMocks
    FamilyMemberBaseService baseService;
    
	@Test
	void testBaseCreateFamilyMember() {
        FamilyMember familyMember = new FamilyMember();
        familyMember.setFamilyId(1L);
        familyMember.setFamilyName("Glik");
        familyMember.setGivenName("Kamil");
        familyMember.setAge(34);
        
        boolean wasCreated = baseService.createFamilyMember(familyMember);
        
        assertTrue(wasCreated);
	}

}
