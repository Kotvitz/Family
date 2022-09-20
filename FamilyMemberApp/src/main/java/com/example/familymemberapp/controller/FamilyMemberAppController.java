package com.example.familymemberapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.familymemberapp.model.FamilyMember;
import com.example.familymemberapp.service.FamilyMemberAppService;

@RestController
public class FamilyMemberAppController {

	private final FamilyMemberAppService service;

	public FamilyMemberAppController(FamilyMemberAppService service) {
		this.service = service;
	}

	@PostMapping("/createFamilyMember")
	public ResponseEntity<HttpStatus> createFamilyMember(@RequestBody FamilyMember familyMember) {
		Boolean result = service.createFamilyMember(familyMember);
		if (result.booleanValue() == true)
			return new ResponseEntity<>(HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/searchFamilyMember/{id}")
	public List<FamilyMember> searchFamilyMember(@PathVariable(value = "id") Long id) {
		return service.searchFamilyMember(id);
	}
}
