package com.management.charitydonation.service;

import java.util.List;

import com.management.charitydonation.dto.CampaignImagesDto;
import com.management.charitydonation.entity.CampaignImages;

public interface CampaignImagesService {
	public List<CampaignImagesDto>getCampaignImage(int id);
	public CampaignImagesDto getRepresentImage(int id);
}
