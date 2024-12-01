package com.management.charitydonation.dto;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecializedDto {
 
	private int idSpecialized;
	private String nameSpecialized;
	private FacultyDto facultyDto;
	private List<UserDto>users;
	private List<RecipientDto>recipients;
}
