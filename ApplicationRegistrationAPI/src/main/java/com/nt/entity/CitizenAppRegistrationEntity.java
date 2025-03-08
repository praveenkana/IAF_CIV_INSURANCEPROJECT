package com.nt.entity;

import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CITIZEN_APPLICATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenAppRegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer appId;
	@Column(length = 15)
	private String serviceNumber;
	@Column(length = 30)
	private String fullName;
	@Column(length = 30)
	private String email;
	@Column(length = 10)
	private String gender;
	private Long phoneNo;
	@Column(length = 30)
	private String stateName;
	private LocalDate dob;
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
