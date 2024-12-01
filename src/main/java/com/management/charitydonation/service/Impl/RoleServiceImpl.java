package com.management.charitydonation.service.Impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.management.charitydonation.dto.RoleDto;
import com.management.charitydonation.entity.Role;
import com.management.charitydonation.mapper.RoleMapper;
import com.management.charitydonation.repository.RoleRepository;
import com.management.charitydonation.service.RoleService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
     RoleRepository roleRepository;
   
	@Override
	public List<RoleDto> getAllRole() {
		List<Role>listRole=roleRepository.findAll();
		return listRole.stream().map(role->RoleMapper.mapRoleDto(role)).collect(Collectors.toList());
	}

	
}
