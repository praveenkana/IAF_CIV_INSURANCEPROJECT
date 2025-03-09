package com.nt.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ChildrenInputs {
	
	private Integer childId;
	private LocalDate childDOB;
	private Integer ServiceNo;
	private Integer caseNo;

}
