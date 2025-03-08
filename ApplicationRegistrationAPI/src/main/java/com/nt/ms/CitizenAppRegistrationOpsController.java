package com.nt.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bindings.CitizenAppRegistrationInputs;
import com.nt.service.AppRegistrationService;
import com.nt.service.InvalidServiceNumberException;

@RestController
@RequestMapping("/citizen-api")
public class CitizenAppRegistrationOpsController {
	@Autowired
	private AppRegistrationService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveCitizenApplication(@RequestBody CitizenAppRegistrationInputs inputs) throws Exception {
		
			Integer appId = service.registerCitizenApplication(inputs);
			if (appId > 0)
				return new ResponseEntity<String>("citizen registered with id " + appId, HttpStatus.CREATED);
			else
				return new ResponseEntity<String>("citizen registration failure ", HttpStatus.NOT_ACCEPTABLE);
		

	}
}
