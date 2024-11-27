package com.management.charitydonation.service.Impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.management.charitydonation.dto.CampaignsDto;
import com.management.charitydonation.entity.Campaigns;
import com.management.charitydonation.mapper.CampaignsMapper;
import com.management.charitydonation.repository.AccountRepository;
import com.management.charitydonation.repository.CampaignsRepository;
import com.management.charitydonation.service.CampaignService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CampaignServiceImpl implements CampaignService{
	CampaignsRepository campaignRepository;

	@Override
	public CampaignsDto createCampaigns(CampaignsDto campaigndto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CampaignsDto> getAllCampaign() {
		List<Campaigns>getAllCampaign=campaignRepository.findAll();
		return getAllCampaign.stream().map(campaign-> CampaignsMapper.mapCampaignsDto(campaign)).collect(Collectors.toList());
	}

	@Override
	public Page<CampaignsDto> getCampaign(int page, int size) {
		Page<Campaigns>getPage=campaignRepository.findAll(PageRequest.of(page, size));
		return getPage.map(campaign->CampaignsMapper.mapCampaignsDto(campaign));
	}

	@Override
	public long countCampaign() {
		long countCampaign=campaignRepository.count();
		return countCampaign;
	}

	@Override
	public Page<CampaignsDto> displayCampaignUser(int page, int size) {
		Page<Campaigns>getCampaignPermit=campaignRepository.getCampaignPermit(1,PageRequest.of(page, size));
		return getCampaignPermit.map(campaign->CampaignsMapper.mapCampaignsDto(campaign));
	}

	@Override
	public Page<CampaignsDto> displayCampaignAdmin(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}
    
	


	

}
