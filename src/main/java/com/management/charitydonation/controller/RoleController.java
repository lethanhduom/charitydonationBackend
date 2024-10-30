package com.management.charitydonation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.charitydonation.dto.RoleDto;
import com.management.charitydonation.service.RoleService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("api/role")
public class RoleController {
	RoleService roleService;
	@GetMapping("/listrole")
	public ResponseEntity<List<RoleDto>> getAllRole() {
		List<RoleDto>listRole=roleService.getAllRole();
		return  ResponseEntity.ok(listRole);
	}
	

}
