package com.management.charitydonation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.charitydonation.dto.SpecializedDto;
import com.management.charitydonation.service.SpecializedService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/specialized")
public class SpecializedController {
	SpecializedService specializedService;
	@GetMapping("/getspecialized")
	public ResponseEntity<List<SpecializedDto>>  getSpecialized () {
		List<SpecializedDto>specializedList=specializedService.getAllSpecialized();
		return ResponseEntity.ok(specializedList);
	}
	@GetMapping("/getspecialized/{id}")
	public ResponseEntity<List<SpecializedDto>> getSpecializedById(@PathVariable ("id") int id){
		List<SpecializedDto>getSpecialized=specializedService.getSpecializedByIdFaculty(id);
		return ResponseEntity.ok(getSpecialized);
	}

}
