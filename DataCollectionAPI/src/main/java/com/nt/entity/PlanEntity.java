package com.nt.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanEntity {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer planId;
	@Column(length = 30)
	private Integer caseNo;
	private String planName;
	private LocalDate startDate;
	private LocalDate endDate;
	@Column(length = 30)
	private String Description;
	@Column(length = 10)
	private String active_sw;
	@Column(length = 30)
	private String createdBy;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate creationDate;
	@Column(length = 30)
	private String updatedBy;
	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDate updationDate;
	

}
