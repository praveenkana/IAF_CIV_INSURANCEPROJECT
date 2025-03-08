package com.nt.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenAppRegistrationInputs {

	private String serviceNumber;
	private String fullName;
	private String email;
	private String gender;
	private Long phoneNo;
	private String stateName;
	private LocalDate dob;

}
