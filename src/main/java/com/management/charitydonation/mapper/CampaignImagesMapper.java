package com.management.charitydonation.mapper;

import com.management.charitydonation.dto.CampaignImagesDto;
import com.management.charitydonation.dto.CampaignsDto;
import com.management.charitydonation.entity.CampaignImages;
import com.management.charitydonation.entity.Campaigns;

public class CampaignImagesMapper {
public static CampaignImagesDto mapCampaignImagesDto (CampaignImages campaignimage) {
	if(campaignimage==null) {
		return null;
	}
	CampaignImagesDto campaignimagedto=new CampaignImagesDto();
	campaignimagedto.setIdImage(campaignimage.getIdImage());
	campaignimagedto.setUrlImage(campaignimage.getUrlImage());
	campaignimagedto.setCampaigndto(CampaignsMapper.mapCampaignsDto(campaignimage.getCampaign()));
	return campaignimagedto;
}
public static CampaignImages mapCampaignImages(CampaignImagesDto campaignimagedto) {
	if(campaignimagedto==null)
		return null;
	CampaignImages campaignimage=new CampaignImages();
	campaignimage.setIdImage(campaignimagedto.getIdImage());
	campaignimage.setUrlImage(campaignimagedto.getUrlImage());
	return campaignimage;
}
}
