package com.example.familyapp.base.service;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.familyapp.base.FamilyBase;
import com.example.familyapp.model.Family;

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
			FamilyBase familyBase = new FamilyBase();
			BeanUtils.copyProperties(family, familyBase);
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
		FamilyBase familyBase = entityManager.createQuery("SELECT * FROM family WHERE id = :id", FamilyBase.class)
				.setParameter("id", id).getSingleResult();
		return new Family(familyBase.getId(), familyBase.getFamilyName(), familyBase.getNrOfInfants(),
				familyBase.getNrOfChildren(), familyBase.getNrOfAdults());
	}
}
