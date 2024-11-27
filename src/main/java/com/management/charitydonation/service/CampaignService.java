package com.management.charitydonation.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.management.charitydonation.dto.CampaignsDto;

public interface CampaignService {
	CampaignsDto createCampaigns (CampaignsDto campaigndto);
	List<CampaignsDto>getAllCampaign();
	public Page<CampaignsDto>getCampaign(int page, int size);
	public long countCampaign();
	public Page<CampaignsDto>displayCampaignUser(int page, int size);
	public Page<CampaignsDto>displayCampaignAdmin(int page,int size);
}

