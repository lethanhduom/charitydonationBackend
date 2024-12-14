package com.management.charitydonation.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/getdonation")
	public ResponseEntity<Page<DonationsDto>>getDonation(@RequestParam("idCampaign") int idCampaign,
			  @RequestParam("page") int page,
		         @RequestParam("size") int size
		       
			)
	{
	return ResponseEntity.ok(donationService.getDonation(idCampaign, page, size));
	}
	
	@GetMapping("/getDonation/{id}")
	public ResponseEntity<List<DonationsDto>>getListDonatinByCampaign(@PathVariable int id){
		List<DonationsDto>list=donationService.getDonationByIdCampaign(id);
		return ResponseEntity.ok(list);
	}
	@PostMapping("/showcampaign")
	public ResponseEntity<Page<DonationsDto>>showDonation(@RequestParam("id") int id,
			 @RequestParam("page") int page,
	         @RequestParam("size") int size
			){
				return ResponseEntity.ok(donationService.getDonationShowUser(id, page, size));
		
	}
}
