package com.management.charitydonation.dto;

import java.time.Year;

import com.management.charitydonation.entity.Account;
import com.management.charitydonation.entity.Faculty;
import com.management.charitydonation.entity.Specialized;

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
	private String idNumber;
	private String gender;
	private String phoneNumber;
	private String email;
	private Year acadamyStartYear;
	private Year acadamyEndYear;
	private String classUser;
	private String address;
	private String fullName;
	private String dateOfBirth;
	private AccountDto accountDto;
	private SpecializedDto specializedDto;
	private FacultyDto facultyDto;
	
}
