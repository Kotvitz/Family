package com.example.familyapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.example.familyapp.model.Family;
import com.example.familyapp.service.FamilyAppService;
import com.example.familymemberapp.model.FamilyMember;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FamilyAppTests {

	@Mock
	RestTemplate restTemplate;

	@Mock
	ResponseEntity<?> response;

	@InjectMocks
	FamilyAppService service;

	@BeforeEach
	public void init() {
		ReflectionTestUtils.setField(service, "uriCreateFamily", "http://localhost:8022/familydb/createFamily");
		ReflectionTestUtils.setField(service, "uriCreateMember",
				"http://localhost:8021/familymemberdb/createFamilyMember");
		ReflectionTestUtils.setField(service, "uriGetSpecificFamily", "http://localhost:8022/familydb/getFamily/");
		ReflectionTestUtils.setField(service, "uriSearchSpecificFamilyMember",
				"http://localhost:8021/familymemberdb/searchFamilyMember/");
	}

	@Test
	void testCreateFamily() {
		when(restTemplate.postForObject(anyString(), Mockito.any(Family.class), Mockito.eq(Long.class))).thenReturn(1L);
		when(restTemplate.postForObject(anyString(), Mockito.any(FamilyMember.class), Mockito.eq(ResponseEntity.class)))
				.thenReturn(new ResponseEntity<>(HttpStatus.CREATED));
		Family family = createFamily();
		Long familyId = service.createFamily(family);
		assertEquals(1L, familyId);
	}

	@Test
	void testGetFamily() {
		when(restTemplate.getForObject(anyString(), Mockito.eq(Family.class))).thenReturn(createFamily());
		when(restTemplate.getForObject(anyString(), Mockito.eq(List.class))).thenReturn(createFamilyMemberList());
		Family family = service.getFamily(1L);
		assertEquals("Glik", family.getFamilyName());
		assertEquals("Kamil", family.getFamilyMemberList().get(0).getGivenName());
		assertEquals(34, family.getFamilyMemberList().get(0).getAge());
		assertEquals(2, family.getNrOfAdults());
		assertEquals(1, family.getNrOfChildren());
		assertEquals(1, family.getNrOfInfants());
	}

	private Family createFamily() {
		Family family = new Family();
		family.setFamilyName("Glik");
		family.setNrOfInfants(1);
		family.setNrOfChildren(1);
		family.setNrOfAdults(2);
		family.setId(1L);
		family.setFamilyMemberList(createFamilyMemberList());
		return family;
	}

	private List<FamilyMember> createFamilyMemberList() {
		FamilyMember member1 = new FamilyMember(1L, "Glik", "Kamil", 34);
		FamilyMember member2 = new FamilyMember(1L, "Glik", "Marta", 34);
		FamilyMember member3 = new FamilyMember(1L, "Glik", "Victoria", 9);
		FamilyMember member4 = new FamilyMember(1L, "Glik", "Valentina", 3);
		List<FamilyMember> familyMemberList = new ArrayList<>();
		familyMemberList.add(member1);
		familyMemberList.add(member2);
		familyMemberList.add(member3);
		familyMemberList.add(member4);
		return familyMemberList;
	}
}
