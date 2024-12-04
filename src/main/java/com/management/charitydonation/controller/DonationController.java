package com.management.charitydonation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.charitydonation.dto.DonationsDto;
import com.management.charitydonation.service.CampaignImagesService;
import com.management.charitydonation.service.CampaignService;
import com.management.charitydonation.service.CloudinaryService;
import com.management.charitydonation.service.DonationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/donation")
public class DonationController {
	private DonationService donationService;
	
	@PostMapping("/create")
	public ResponseEntity<DonationsDto>createDonation(@RequestBody DonationsDto donationDto){
		DonationsDto donation=donationService.createDonations(donationDto);
		return new ResponseEntity<>(donation,HttpStatus.CREATED);
		
	}

}
