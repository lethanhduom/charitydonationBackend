package com.management.charitydonation.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.management.charitydonation.dto.SpecializedDto;
import com.management.charitydonation.entity.Specialized;
import com.management.charitydonation.mapper.SpecializedMapper;
import com.management.charitydonation.repository.SpecializedRepository;
import com.management.charitydonation.service.SpecializedService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SpecializedServiceImpl implements SpecializedService{
    SpecializedRepository specializedRepositoty;
	@Override
	public List<SpecializedDto> getAllSpecialized() {
	List<Specialized>listSpecialized=specializedRepositoty.findAll();
	
		return listSpecialized.stream().map(specialized->SpecializedMapper.mapSpecializedDto(specialized)).collect(Collectors.toList());
	}
	@Override
	public List<SpecializedDto> getSpecializedByIdFaculty(int id) {
		List<Specialized>getListSpecialized=specializedRepositoty.getByFacultyId(id);
		return  getListSpecialized.stream().map(spec->SpecializedMapper.mapSpecializedDto(spec)).collect(Collectors.toList());
	}

}
