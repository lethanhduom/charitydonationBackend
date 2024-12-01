package com.management.charitydonation.dto;

import java.util.List;
import java.util.Set;

import com.management.charitydonation.entity.Employee;
import com.management.charitydonation.entity.Recipient;
import com.management.charitydonation.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyDto {
private int idFaculty;
private String nameFaculty;
private List<SpecializedDto>specializeds;
private List<EmployeeDto>employees;
private List<UserDto>users;
private List<RecipientDto>recipients;
}
