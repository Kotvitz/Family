package com.example.familymemberapp.base.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.familymemberapp.base.FamilyMemberBase;
import com.example.familymemberapp.model.FamilyMember;

@Service
public class FamilyMemberBaseService {

	private static Logger logger = LogManager.getLogger(FamilyMemberBaseService.class);

	private final EntityManager entityManager;

	@Autowired
	public FamilyMemberBaseService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean createFamilyMember(FamilyMember familyMember) {
		try {
			FamilyMemberBase familyMemberBase = new FamilyMemberBase();
			BeanUtils.copyProperties(familyMember, familyMemberBase);
			entityManager.persist(familyMemberBase);
			logger.info("Member of family " + familyMember.getGivenName() + " was correctly recorded in the database.");
			return true;
		} catch (Exception e) {
			logger.error("An error occurred while trying to record the member of family " + familyMember.getGivenName()
					+ " to the database.\n" + e.getMessage());
			return false;
		}
	}

	public List<FamilyMember> searchFamilyMember(Long familyId) {
		List<FamilyMemberBase> familyMemberBaseList = entityManager
				.createQuery("SELECT * FROM familymember WHERE familyId = :familyId", FamilyMemberBase.class)
				.setParameter("familyId", familyId).getResultList();
		List<FamilyMember> familyMemberList = familyMemberBaseList.stream()
				.map(FamilyMemberBase::copyFromBaseToFamilyMemberModel).collect(Collectors.toList());
		return familyMemberList;
	}
}
