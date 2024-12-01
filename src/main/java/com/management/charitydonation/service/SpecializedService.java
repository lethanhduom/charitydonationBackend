package com.management.charitydonation.service;

import java.util.List;

import com.management.charitydonation.dto.SpecializedDto;

public interface SpecializedService {
  public List<SpecializedDto>getAllSpecialized();
  public List<SpecializedDto>getSpecializedByIdFaculty(int id);
}
