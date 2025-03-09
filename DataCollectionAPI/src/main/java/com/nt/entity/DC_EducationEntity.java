package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="DC_EDUCATION")
public class DC_EducationEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer educationId;
	private Integer caseNo;
	private String highestQualification;
	private Integer passOutYear;
	

}
