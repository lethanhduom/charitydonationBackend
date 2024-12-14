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
	public Page<CampaignsDto>displayCampaignUser(int page, int size);
	public Page<CampaignsDto>displayCampaignAdmin(int page,int size,int status);
    public String  updateCampaignStatus(int status,int idEmployee,int id, String endDateExpect);
    public CampaignsDto getCampaignById(int id);
    public String UpdateCurrentMoneyCampaign(Float money,int id);
    public String  updateCampaignStatusSuccess(int status,int idEmployee,int id, String endDateExpect);
    public String updateCampaign(Campaigns campaign);
 
}

