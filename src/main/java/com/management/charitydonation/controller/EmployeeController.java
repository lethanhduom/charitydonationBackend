package com.management.charitydonation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.charitydonation.dto.EmployeeDto;
import com.management.charitydonation.service.EmployeeService;
import com.management.charitydonation.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("account/employee")
public class EmployeeController {
	private EmployeeService employeeservice;
	
   @PostMapping("/create")
   public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeedto){
	   EmployeeDto saveEmployee=employeeservice.createEmployee(employeedto);
	   return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
   }
   @PutMapping("abc")
   public ResponseEntity<String>abc(){
	   return ResponseEntity.ok("from abc");
   }
	
}
