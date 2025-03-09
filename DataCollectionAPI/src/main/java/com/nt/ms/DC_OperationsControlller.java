package com.nt.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bindings.ChildrenInputs;
import com.nt.bindings.DC_SummaryInputs;
import com.nt.bindings.EducationInputs;
import com.nt.bindings.IncomeInputs;
import com.nt.bindings.PlanSelectionInputs;
import com.nt.service.DC_ManagementService;

@RequestMapping("/dc-api")
@RestController
public class DC_OperationsControlller {

	@Autowired
	private DC_ManagementService service;

	@PostMapping("/getCaseNo/{number}")
	public ResponseEntity<Integer> generateCaseNuber(@PathVariable Integer number) {
		Integer caseNo = service.generateCaseNo(number);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.OK);
	}

	@GetMapping("/planNames")
	public ResponseEntity<List<String>> displayPlanNames() {
		List<String> list = service.showAllPlans();
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Integer> savePlanSelection(@RequestBody PlanSelectionInputs inputs) {

		Integer caseNo = service.savePlanSelction(inputs);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.OK);

	}

	@PostMapping("/saveIncome")
	public ResponseEntity<Integer> saveIncomeDetails(@RequestBody IncomeInputs inputs) {

		Integer caseNo = service.saveIncomeDetails(inputs);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.OK);
	}

	@PostMapping("/saveEducation")
	public ResponseEntity<Integer> saveEducationDetails(@RequestBody EducationInputs inputs) {

		Integer caseNo = service.saveEducationDetails(inputs);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.OK);
	}

	@PostMapping("/savePlan")
	public ResponseEntity<Integer> savePlanDetails(@RequestBody PlanSelectionInputs inputs) {

		Integer caseNo = service.savePlanSelction(inputs);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.OK);
	}
	@PostMapping("saveChildren")
	public ResponseEntity<Integer> saveChildrenDetails(@RequestBody List<ChildrenInputs> inputs) {
		
		Integer caseNo = service.saveChildrenDetails(inputs);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.OK);
	}
	
	@GetMapping("/summary/{caseNo}")
	public ResponseEntity<DC_SummaryInputs> showSummaryInputs(@PathVariable Integer no){
		
		DC_SummaryInputs summary = service.showDC_Summary(no);
		return new ResponseEntity<DC_SummaryInputs>(summary, HttpStatus.OK);
	}
}
