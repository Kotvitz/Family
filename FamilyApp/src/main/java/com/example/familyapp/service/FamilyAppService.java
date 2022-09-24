package com.example.familyapp.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.familyapp.model.Family;
import com.example.familymemberapp.model.FamilyMember;
import com.example.familymemberapp.service.FamilyMemberAppService;

@Service
public class FamilyAppService {

	private static Logger logger = LogManager.getLogger(FamilyMemberAppService.class);

	@Value("${familyAppService.uriCreateFamily}")
	private String uriCreateFamily;

	@Value("${familyAppService.uriCreateMember}")
	private String uriCreateMember;

	@Value("${familyAppService.uriGetSpecificFamily}")
	private String uriGetSpecificFamily;

	@Value("${familyAppService.uriSearchSpecificFamilyMember}")
	private String uriSearchSpecificFamilyMember;

	private final RestTemplate restTemplate;

	@Autowired
	public FamilyAppService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Long createFamily(Family familyToCreate) {
		boolean isValid = validateFamilyData(familyToCreate);
		if (isValid == true) {
			Family family = new Family();
			BeanUtils.copyProperties(familyToCreate, family);
			Long id = restTemplate.postForObject(uriCreateFamily, family, Long.class);
			for (FamilyMember member : familyToCreate.getFamilyMemberList()) {
				member.setFamilyId(id);
				ResponseEntity response = restTemplate.postForObject(uriCreateMember, member, ResponseEntity.class);
				if (response.equals(new ResponseEntity<>(HttpStatus.NO_CONTENT))) {
					logger.error("Error while following family member was creating: " + member.getGivenName() + " "
							+ member.getFamilyName());
					return null;
				} else {
					return id;
				}

			}
		}
		return null;
	}

	public Family getFamily(Long id) {
		Family family = restTemplate.getForObject(uriGetSpecificFamily + id.toString(), Family.class);
		List<FamilyMember> memberList = restTemplate.getForObject(uriGetSpecificFamily + id.toString(),
				List.class);
		family.setFamilyMemberList(memberList);
		return family;
	}

	private boolean validateFamilyData(Family family) {
		int nrOfInfants = 0, nrOfChildren = 0, nrOfAdults = 0;
		logger.info("Validate family data... ");
		for (FamilyMember member : family.getFamilyMemberList()) {
			if (member.getAge() >= 0 && member.getAge() < 4) {
				nrOfInfants = nrOfInfants + 1;
			} else if (member.getAge() >= 4 && member.getAge() < 16) {
				nrOfChildren = nrOfChildren + 1;
			} else if (member.getAge() >= 16) {
				nrOfAdults = nrOfAdults + 1;
			}
		}

		if (family.getNrOfInfants() == nrOfInfants && family.getNrOfChildren() == nrOfChildren
				&& family.getNrOfAdults() == nrOfAdults) {
			logger.info("Number of particular family members is correct.");
			return true;
		} else {
			logger.error("Validation error: The number of family members in "
					+ "particular age groups was incorrectly entered.");
			return false;
		}
	}
}
