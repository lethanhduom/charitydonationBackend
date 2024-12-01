package com.management.charitydonation.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.management.charitydonation.dto.CampaignsDto;
import com.management.charitydonation.entity.Campaigns;

public interface CampaignService {
	Campaigns createCampaigns (Campaigns campaigndto, List<MultipartFile> images) throws IOException;
	public Page<CampaignsDto>getCampaign(int page, int size);
	public long countCampaign();
	public Page<Campaigns>displayCampaignUser(int page, int size);
	public Page<Campaigns>displayCampaignAdmin(int page,int size);
    public CampaignsDto updateCampaignStatus(int status,int id);
    public CampaignsDto getCampaignById(int id);
}

