package com.example.familyapp.base.service;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.familyapp.model.Family;
import com.example.familymemberapp.service.FamilyMemberAppService;

@Service
public class FamilyBaseService {

	private static Logger logger = LogManager.getLogger(FamilyBaseService.class);

	private final EntityManager entityManager;

	@Autowired
	public FamilyBaseService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Long createFamily(Family family) {
		try {
			entityManager.persist(family);
			logger.info("Family " + family.getFamilyName() + " was correctly recorded in the database.");
			return family.getId();
		} catch (Exception e) {
			logger.error("An error occurred while trying to record the family " + family.getFamilyName()
					+ " to the database.\n" + e.getMessage());
			return null;
		}
	}

	public Family getFamily(Long id) {
		Family family = entityManager.createQuery("SELECT * FROM Family WHERE id = :id", Family.class)
				.setParameter("id", id).getSingleResult();
		return family;
	}
}
