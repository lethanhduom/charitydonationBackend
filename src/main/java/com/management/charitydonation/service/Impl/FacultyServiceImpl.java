package com.management.charitydonation.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.management.charitydonation.dto.FacultyDto;
import com.management.charitydonation.entity.Faculty;
import com.management.charitydonation.mapper.FacultyMapper;
import com.management.charitydonation.repository.FacultyRepository;
import com.management.charitydonation.service.FacultyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {
FacultyRepository facultyRepository;

@Override
public List<FacultyDto> listFaculty() {
	List<Faculty>listFaculty=facultyRepository.findAll();
	return listFaculty.stream().map(faculty->FacultyMapper.mapFacultyDto(faculty)).collect(Collectors.toList());
}

}
