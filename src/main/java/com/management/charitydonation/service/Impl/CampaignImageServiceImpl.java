package com.management.charitydonation.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	@Override
	public CampaignImagesDto getRepresentImage(int id) {
		Pageable pageable=PageRequest.of(0, 1);
		 Page<CampaignImages> page = campaignImagesRepository.getRepresentImage(id, pageable);
//		 CampaignImagesMapper.mapCampaignImagesDto(page.getContent().isEmpty() )? null : page.getContent().get(0);
		 return page.getContent().stream().map(image->CampaignImagesMapper.mapCampaignImagesDto(image)).collect(Collectors.toList()).isEmpty()?null:CampaignImagesMapper.mapCampaignImagesDto(page.getContent().get(0));
	}

}
