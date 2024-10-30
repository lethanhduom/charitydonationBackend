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
	private String faculty;
	private String specialized;
	private String classRecipient;
	private Year acadamyStartYear;
	private Year acadamyEndYear;
	
}
