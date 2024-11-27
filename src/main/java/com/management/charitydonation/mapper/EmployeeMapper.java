package com.management.charitydonation.mapper;

import com.management.charitydonation.dto.EmployeeDto;
import com.management.charitydonation.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapEmployeeDto(Employee employee) {
		if(employee==null)
			return null;
		EmployeeDto employeedto=new EmployeeDto();
		employeedto.setIdNumber(employee.getIdNumber());
		employeedto.setIdEmployee(employee.getIdEmployee());
		employeedto.setAddress(employee.getAddress());
		employeedto.setEmail(employee.getEmail());
		employeedto.setFaculty(employee.getFaculty());
		employeedto.setFullName(employee.getFullName());
		employeedto.setGender(employee.getGender());
		employeedto.setPhoneNumber(employee.getPhoneNumber());
		employeedto.setDateOfBirth(employee.getDateOfBirth());
		employeedto.setAccountDto(AccountMapper.mapAccountDto(employee.getAccount1()));
		return employeedto;
	}
	public static Employee mapEmployee (EmployeeDto employeedto) {
		if(employeedto==null) {
			return null;
		}
		Employee employee=new Employee();
		employee.setIdEmployee(employeedto.getIdEmployee());
		employee.setFullName(employeedto.getFullName());
		employee.setIdNumber(employeedto.getIdNumber());
		employee.setAddress(employeedto.getAddress());
		employee.setEmail(employeedto.getEmail());
		employee.setFaculty(employeedto.getFaculty());
		employee.setGender(employeedto.getGender());
		employee.setPhoneNumber(employeedto.getPhoneNumber());
		employee.setDateOfBirth(employeedto.getDateOfBirth());
		employee.setAccount1(AccountMapper.mapAccount(employeedto.getAccountDto()));
		return employee;
	}

}
