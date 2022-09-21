package com.example.familyapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.familyapp.model.Family;
import com.example.familyapp.service.FamilyAppService;

@RestController
public class FamilyAppController {
	
    private final FamilyAppService service;
    
    public FamilyAppController(FamilyAppService service) {
        this.service = service;
    }
    
    @PostMapping("/createFamily")
    public Long createFamily(@RequestBody Family familyToCreate) {
    	return service.createFamily(familyToCreate);
    }
    
    @GetMapping("/getFamily/{id}")
    public Family getFamily(@PathVariable(value = "id") Long id) {
    	return service.getFamily(id);
    }
}
