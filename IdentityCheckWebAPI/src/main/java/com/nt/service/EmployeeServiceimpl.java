package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CivEmployee;
import com.nt.repository.EmployeeCheckRepository;

@Service
public class EmployeeServiceimpl implements EmployeeService {
	@Autowired
	private EmployeeCheckRepository employeerepo;

	@Override
	public boolean wasEmployee(String serviceNumber) {
			//check employee present in database
			
	        Optional<CivEmployee> employee = employeerepo.findById(serviceNumber);
	        return employee.isPresent();
	    
		
	}

}
