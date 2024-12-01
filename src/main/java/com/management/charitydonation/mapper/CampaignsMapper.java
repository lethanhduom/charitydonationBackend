package com.management.charitydonation.mapper;

import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.dto.CampaignsDto;import com.management.charitydonation.dto.EmployeeDto;
import com.management.charitydonation.entity.Campaigns;

public class CampaignsMapper {
public static CampaignsDto mapCampaignsDto(Campaigns campaign) {
	if(campaign==null) {
		return null;
	}
	CampaignsDto campaigndto=new CampaignsDto();
	campaigndto.setIdCampaign(campaign.getIdCampaign());
	campaigndto.setCampaignName(campaign.getCampaignName());
	campaigndto.setContent(campaign.getContent());
	campaigndto.setCurrentAmmout(campaign.getCurrentAmmout());
	campaigndto.setEndDate(campaign.getEndDate());
	campaigndto.setStartDate(campaign.getStartDate());
	campaigndto.setEndDateExpect(campaign.getEndDateExpect());
	campaigndto.setStatus(campaign.getStatus());
	campaigndto.setAccountDto(AccountMapper.mapAccountDto(campaign.getAccount2()));
	campaigndto.setEmployeeDto(EmployeeMapper.mapEmployeeDto(campaign.getEmployee()));
	campaigndto.setRecipientDto(RecipientMapper.mapRecipientDto(campaign.getRecipient()));
	
	return campaigndto;
}
public static Campaigns mapCampaigns(CampaignsDto campaigndto) {
	if(campaigndto==null) {
		return null;
	}
	Campaigns campaigns=new Campaigns();
	campaigns.setIdCampaign(campaigndto.getIdCampaign());
	campaigns.setCampaignName(campaigndto.getCampaignName());
	campaigns.setContent(campaigndto.getContent());
	campaigns.setCurrentAmmout(campaigndto.getCurrentAmmout());
	campaigns.setEndDate(campaigndto.getEndDate());
	campaigns.setStartDate(campaigndto.getStartDate());
	campaigns.setStatus(campaigndto.getStatus());
	campaigns.setAccount2(AccountMapper.mapAccount(campaigndto.getAccountDto()));
	campaigns.setEmployee(EmployeeMapper.mapEmployee(campaigndto.getEmployeeDto()));
	campaigns.setRecipient(RecipientMapper.mapRecipient(campaigndto.getRecipientDto()));
	return campaigns;
}
}