package com.management.charitydonation.service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.management.charitydonation.Response.UpdateResponse;
import com.management.charitydonation.dto.CampaignImagesDto;
import com.management.charitydonation.dto.CampaignsDto;
import com.management.charitydonation.entity.CampaignImages;
import com.management.charitydonation.entity.Campaigns;
import com.management.charitydonation.mapper.CampaignsMapper;
import com.management.charitydonation.repository.AccountRepository;
import com.management.charitydonation.repository.CampaignsRepository;
import com.management.charitydonation.service.CampaignService;
import com.management.charitydonation.service.CloudinaryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class CampaignServiceImpl implements CampaignService{
	CampaignsRepository campaignRepository;
     CloudinaryService cloudinaryService;
	@Override
	public Campaigns createCampaigns(Campaigns campaign,List<MultipartFile> images) throws IOException {
//		Campaigns campaign=CampaignsMapper.mapCampaigns(campaigndto);
//		Campaigns saveCampaign=campaignRepository.save(campaign);
		 List<CampaignImages> uploadedImages = new ArrayList<>();
		  for (MultipartFile file : images) {
			 String urlImage= cloudinaryService.uploadImage(file);
			  CampaignImages campaignImage=new CampaignImages();
			  campaignImage.setUrlImage(urlImage);
//			  campaignImage.setId(saveCampaign.getIdCampaign());
			  campaignImage.setCampaign(campaign);
			  uploadedImages.add(campaignImage);
		  }
		  campaign.setCampaignimages(uploadedImages);
		  Campaigns saveCampaign=campaignRepository.save(campaign);
		return saveCampaign;
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
	public Page<CampaignsDto> displayCampaignAdmin(int page, int size,int status) {
		Page<Campaigns>getCampaignPermit=campaignRepository.getCampaignPermit(status,PageRequest.of(page, size));
		return getCampaignPermit.map(campaign->CampaignsMapper.mapCampaignsDto(campaign));
	}


	@Override
	public String updateCampaignStatus(int status, int idRecipient, int id, String startDate) {
		int campaign=campaignRepository.updateCampaign(status, idRecipient,startDate,id );
		if(campaign>0) {
			return "update success";
		}else 
		return "update failed";
	}


	@Override
	public CampaignsDto getCampaignById(int id) {
		Campaigns campaign=campaignRepository.findByIdCampaign(id);
		return CampaignsMapper.mapCampaignsDto(campaign);
	}


	@Override
	public String UpdateCurrentMoneyCampaign(Float money, int id) {
		int updateCurrentMoney=campaignRepository.updateCurrentMoney(money, id);
		if(updateCurrentMoney>0) {
			return "Update Success";
		}
		return "Update Failed";
	}


	@Override
	public String updateCampaignStatusSuccess(int status, int idEmployee, int id, String endDateExpect) {
		int campaign=campaignRepository.updateCampaign(status, idEmployee,endDateExpect,id );
		if(campaign>0) {
			return "update success";
		}else 
		return "update failed";
	}


	@Override
	public String updateCampaign(Campaigns campaign) {
		Campaigns getCampaign=campaignRepository.findByIdCampaign(campaign.getIdCampaign());
		if(campaign==null) {
			return "Not Found Campaign";
		}
		getCampaign.setCampaignName(campaign.getCampaignName());
		getCampaign.setContent(campaign.getContent());
		getCampaign.setCurrentAmmout(campaign.getCurrentAmmout());
		getCampaign.setTargetAmount(campaign.getTargetAmount());
		getCampaign.setEndDateExpect(campaign.getEndDateExpect());
		getCampaign.setStartDate(campaign.getStartDate());
		Campaigns updateCampaign=campaignRepository.save(getCampaign);
		return "update successful";
	}
	
 

}
