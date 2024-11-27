package com.management.charitydonation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.management.charitydonation.dto.CampaignsDto;
import com.management.charitydonation.service.AccountService;
import com.management.charitydonation.service.CampaignService;

import lombok.AllArgsConstructor;

//@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
//@RequestMapping("api/admin/campaign")
public class CampaignController {
	private CampaignService campaignService;
//	@GetMapping
//	ResponseEntity<List<CampaignsDto>>getCampaing(){
//		List<CampaignsDto>listCampaign=campaignService.getAllCampaign();
//		return ResponseEntity.ok(listCampaign);
//	}


	

}
