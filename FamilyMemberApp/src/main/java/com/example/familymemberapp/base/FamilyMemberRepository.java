package com.example.familymemberapp.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMemberBase, Long> {

}
