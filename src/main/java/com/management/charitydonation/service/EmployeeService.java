package com.management.charitydonation.service;

import com.management.charitydonation.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee (EmployeeDto employeedto);
	EmployeeDto getEmployeeById(int id);
	EmployeeDto getEmployeeByIdAccount(int id);
}
