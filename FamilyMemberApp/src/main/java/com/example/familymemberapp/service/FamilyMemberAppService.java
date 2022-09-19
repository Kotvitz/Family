package com.example.familymemberapp.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.familymemberapp.model.FamilyMember;

@Service
public class FamilyMemberAppService {

	private static Logger logger = LogManager.getLogger(FamilyMemberAppService.class);

	@Value("${familyMemberAppService.createMember}")
	private String uriCreateMember;

	@Value("${familyMemberAppService.searchMember}")
	private String uriSearchMember;

	private final RestTemplate restTemplate;

	@Autowired
	public FamilyMemberAppService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Boolean createFamilyMember(FamilyMember familyMember) {
		try {
			restTemplate.postForObject(uriCreateMember, familyMember, FamilyMember.class);
			logger.info("Request was sent to service: " + uriCreateMember);
			return true;
		} catch (Exception e) {
			logger.error("Call of service " + uriCreateMember + " has failed.");
			logger.error(e.getMessage());
			return false;
		}
	}

	public List<FamilyMember> searchFamilyMember(Long id) {
		List<FamilyMember> memberList = restTemplate.getForObject(uriSearchMember + id.toString(), List.class);
		logger.info("Data of family with ID " + id.toString() + " was received.");
		return memberList;
	}
}
