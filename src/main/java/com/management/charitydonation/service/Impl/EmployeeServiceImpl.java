package com.management.charitydonation.service.Impl;

import org.springframework.stereotype.Service;

import com.management.charitydonation.dto.EmployeeDto;
import com.management.charitydonation.entity.Employee;
import com.management.charitydonation.mapper.EmployeeMapper;
import com.management.charitydonation.repository.EmployeeRepository;
import com.management.charitydonation.repository.UserRepository;
import com.management.charitydonation.service.EmployeeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeerepository;
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeedto) {
		Employee employee=EmployeeMapper.mapEmployee(employeedto);
		Employee saveEmployee=employeerepository.save(employee);
		return EmployeeMapper.mapEmployeeDto(saveEmployee);
	
	}
	
	

}
