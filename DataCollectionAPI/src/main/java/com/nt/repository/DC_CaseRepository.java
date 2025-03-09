package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.DC_CaseEntity;

public interface DC_CaseRepository extends JpaRepository<DC_CaseEntity, Integer> {
	
	public DC_CaseEntity findByCaseNo(Integer caseNo);

}
