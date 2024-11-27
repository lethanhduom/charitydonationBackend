package com.management.charitydonation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	private int idEmployee;
	private String fullName;
	private String idNumber;
	private String faculty;
	private String gender;
	private String phoneNumber;
	private String email;
	private String address;
	private String dateOfBirth;
	private AccountDto accountDto;
}
