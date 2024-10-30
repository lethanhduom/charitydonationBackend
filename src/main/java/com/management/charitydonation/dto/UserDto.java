package com.management.charitydonation.dto;

import java.time.Year;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	
	private int idUser;
	private int idNumber;
	private String gender;
	private String phoneNumber;
	private String email;
	private Year acadamyStartYear;
	private Year acadamyEndYear;
	private String faculty;
	private String classUser;
	private String address;
	private String fullName;
	private AccountDto accountDto;
	
}
