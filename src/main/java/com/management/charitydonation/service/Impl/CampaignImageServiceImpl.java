package com.management.charitydonation.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.management.charitydonation.dto.CampaignImagesDto;
import com.management.charitydonation.entity.CampaignImages;
import com.management.charitydonation.mapper.CampaignImagesMapper;
import com.management.charitydonation.repository.CampaignImagesRepository;
import com.management.charitydonation.service.CampaignImagesService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CampaignImageServiceImpl implements CampaignImagesService {
    CampaignImagesRepository campaignImagesRepository;
	@Override
	public List<CampaignImagesDto> getCampaignImage(int id) {
		List<CampaignImages>getCampaignImages=campaignImagesRepository.getCampaignImageByIdCampaign(id);
		return getCampaignImages.stream().map(image->CampaignImagesMapper.mapCampaignImagesDto(image)).collect(Collectors.toList());
	}

}
