package com.example.familymemberapp.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.familymemberapp.model.FamilyMember;
import com.example.familymemberapp.service.FamilyMemberAppService;

@RestController
@RequestMapping("/familymemberdb")
public class FamilyMemberBaseController {

	private final FamilyMemberAppService service;

	@Autowired
	public FamilyMemberBaseController(FamilyMemberAppService service) {
		this.service = service;
	}

	@PostMapping("/createFamilyMember")
	public ResponseEntity<HttpStatus> createFamilyMember(@RequestBody FamilyMember familyMember) {
		boolean wasMemberCreated = service.createFamilyMember(familyMember);
		if (wasMemberCreated)
			return new ResponseEntity<>(HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/searchFamilyMember/{id}")
	public List<FamilyMember> searchFamilyMember(@PathVariable("id") Long id) {
		return service.searchFamilyMember(id);
	}
}
