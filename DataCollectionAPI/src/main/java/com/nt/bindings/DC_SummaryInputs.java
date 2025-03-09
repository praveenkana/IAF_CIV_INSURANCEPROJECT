package com.nt.bindings;

import java.util.List;

import lombok.Data;

@Data
public class DC_SummaryInputs {
	
	private String planName;
	private PlanSelectionInputs planInputs;
	private EducationInputs edInputs;
	private IncomeInputs incomeInputs;
	private List<ChildrenInputs> chInputs;
	private CitizenAppRegistrationInputs citizen;

}
