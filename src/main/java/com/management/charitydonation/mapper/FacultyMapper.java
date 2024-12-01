package com.management.charitydonation.mapper;

import com.management.charitydonation.dto.FacultyDto;
import com.management.charitydonation.entity.Faculty;

public class FacultyMapper {
public static FacultyDto mapFacultyDto(Faculty faculty) {
	if(faculty==null) {
		return null;
	}
	FacultyDto facultyDto=new FacultyDto();
	facultyDto.setIdFaculty(faculty.getIdFaculty());
	facultyDto.setNameFaculty(faculty.getNameFaculty());
	return facultyDto;
}
public static Faculty mapFaculty(FacultyDto facultyDto) {
	if(facultyDto==null) {
		return null;
	}
	Faculty faculty=new Faculty();
	faculty.setIdFaculty(facultyDto.getIdFaculty());
	faculty.setNameFaculty(facultyDto.getNameFaculty());
	return faculty;
}
}
