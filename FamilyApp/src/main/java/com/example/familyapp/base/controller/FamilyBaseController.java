package com.example.familyapp.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.familyapp.base.service.FamilyBaseService;
import com.example.familyapp.model.Family;

@RestController
@RequestMapping("/familydb")
public class FamilyBaseController {

	private final FamilyBaseService service;

	@Autowired
	public FamilyBaseController(FamilyBaseService service) {
		this.service = service;
	}

	@PostMapping("/createFamily")
	public Long createFamily(@RequestBody Family family) {
		return service.createFamily(family);
	}

	@GetMapping("/getFamily/{id}")
	public Family getFamily(@PathVariable("id") Long id) {
		return service.getFamily(id);
	}

}
