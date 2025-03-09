package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.DC_EducationEntity;

public interface DC_EducationRepository extends JpaRepository<DC_EducationEntity, Integer> {

	public DC_EducationEntity findByCaseNo(Integer caseNo);
}
