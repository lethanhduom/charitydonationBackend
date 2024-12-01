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
public class RecipientDto {
	private int idRecipient;
	private String numberStudent;
	private String fullName;
	private String classRecipient;
	private String acadamyStartYear;
	private String acadamyEndYear;
	private FacultyDto facultyDto;
	private SpecializedDto specializedDto; 
	
}
