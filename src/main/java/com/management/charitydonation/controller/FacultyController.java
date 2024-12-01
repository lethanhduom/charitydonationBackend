package com.management.charitydonation.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.charitydonation.dto.FacultyDto;
import com.management.charitydonation.entity.Faculty;
import com.management.charitydonation.service.FacultyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/faculty")
public class FacultyController {
	FacultyService facultyService;
	@GetMapping("/getfaculty")
	public ResponseEntity<List<FacultyDto>> getFaculty(){
		List<FacultyDto>listFaculty=facultyService.listFaculty();
		return ResponseEntity.ok(listFaculty);
	}

}
