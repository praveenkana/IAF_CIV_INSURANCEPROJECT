package com.nt.service;

import java.util.List;

import com.nt.bindings.ChildrenInputs;
import com.nt.bindings.DC_SummaryInputs;
import com.nt.bindings.EducationInputs;
import com.nt.bindings.IncomeInputs;
import com.nt.bindings.PlanSelectionInputs;

public interface DC_ManagementService {

	public Integer generateCaseNo(Integer appId);
	public List<String> showAllPlans();
	public Integer savePlanSelction(PlanSelectionInputs plan);
	public Integer saveIncomeDetails(IncomeInputs income);
	public Integer saveEducationDetails(EducationInputs education);
	public Integer saveChildrenDetails(List<ChildrenInputs> children);
	public DC_SummaryInputs showDC_Summary(Integer caseNo);
	
	

}
