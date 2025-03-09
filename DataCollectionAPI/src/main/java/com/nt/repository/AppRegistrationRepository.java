package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CitizenAppRegistrationEntity;

public interface AppRegistrationRepository extends JpaRepository<CitizenAppRegistrationEntity, Integer> {

	public CitizenAppRegistrationEntity findByCaseNo(Integer caseNo);
}
