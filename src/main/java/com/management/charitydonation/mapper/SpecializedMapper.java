package com.management.charitydonation.mapper;

import com.management.charitydonation.dto.SpecializedDto;
import com.management.charitydonation.entity.Specialized;

public class SpecializedMapper {
public static SpecializedDto mapSpecializedDto(Specialized specialiazed) {
	if(specialiazed==null)
		return null;
	SpecializedDto specializedDto=new SpecializedDto();
	specializedDto.setIdSpecialized(specialiazed.getIdSpecialized());
	specializedDto.setNameSpecialized(specialiazed.getNameSpecialized());
	return specializedDto;
}
public static Specialized mapSpecialized(SpecializedDto specializedDto) {
	if(specializedDto==null)
		return null;
	Specialized specialized=new Specialized();
	specialized.setIdSpecialized(specializedDto.getIdSpecialized());
	specialized.setNameSpecialized(specializedDto.getNameSpecialized());
	return specialized;
}
}
