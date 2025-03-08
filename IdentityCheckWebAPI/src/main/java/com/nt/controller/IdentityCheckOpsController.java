package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.service.EmployeeService;

@RequestMapping("/check")
@RestController
public class IdentityCheckOpsController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/identity/{serviceNumber}")
    public ResponseEntity<String> checkEmployeeId(@PathVariable String serviceNumber) {
        // Validate service number
        if (serviceNumber == null || serviceNumber.isEmpty() || serviceNumber.length() != 6 ) {
            return new ResponseEntity<>("Invalid service number", HttpStatus.BAD_REQUEST);
        }
        
        // Check employee availability in database
        if (service.wasEmployee(serviceNumber)) {
            return new ResponseEntity<>("Employee found with id no "+serviceNumber, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        }
    }
}
