package com.management.charitydonation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;

import com.management.charitydonation.dto.CampaignImagesDto;
import com.management.charitydonation.dto.CampaignsDto;
import com.management.charitydonation.dto.FacultyDto;
import com.management.charitydonation.dto.RecipientDto;
import com.management.charitydonation.dto.SpecializedDto;
import com.management.charitydonation.entity.CampaignImages;
import com.management.charitydonation.entity.Campaigns;
import com.management.charitydonation.entity.Faculty;
import com.management.charitydonation.entity.Recipient;
import com.management.charitydonation.entity.Specialized;
import com.management.charitydonation.mapper.AccountMapper;
import com.management.charitydonation.service.AccountService;
import com.management.charitydonation.service.CampaignImagesService;
import com.management.charitydonation.service.CampaignService;
import com.management.charitydonation.service.CloudinaryService;
import com.paypal.api.payments.Image;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/campaign")
public class CampaignController {
	private CampaignService campaignService;
    private CloudinaryService cloudinaryService;
    private CampaignImagesService campaignImagesService;
    private AccountService accountService;
    @PostMapping ("/create")
    public ResponseEntity<?> createCampaign(@RequestParam ("campaignName") String campaignName,
    		@RequestParam("content") String content,
    		@RequestParam ("targetAmount") float targetAmount,
    		@RequestParam ("currentAmount") float currentAmount,
//    		@RequestParam("startDate") String startDate,
    		@RequestParam("numberStudent") String numberStudent,
    		@RequestParam("fullName") String fullName,
    		@RequestParam("faculty") int faculty,
    		@RequestParam("specialized") int specialized,
    		@RequestParam("classRecipient") String classRecipient,
    		@RequestParam("startYear") String startYear,
    		@RequestParam("endYear") String endYear,
//    		@RequestParam ("endDate") String endDate,
    		@RequestParam ("endDateExpect") String endDateExpect,
    		@RequestParam ("status") int status,

    		@RequestParam("files") List<MultipartFile> files){
    	try {
    		Campaigns campaignDto=new Campaigns();
    		Recipient recipientDto=new Recipient();
    		Faculty facultyDto=new Faculty();
    		Specialized specializedDto=new Specialized();
    		campaignDto.setCampaignName(campaignName);
    		campaignDto.setContent(content);
    		campaignDto.setTargetAmount(20000000);
    		campaignDto.setCurrentAmmout(currentAmount);
//    		campaignDto.setStartDate(startDate);
//    		campaignDto.setEndDate(endDate);
    		campaignDto.setEndDateExpect(endDateExpect);
    		campaignDto.setStatus(status);
    		facultyDto.setIdFaculty(faculty);
    		specializedDto.setIdSpecialized(specialized);
    		recipientDto.setFullName(fullName);
    		recipientDto.setNumberStudent(numberStudent);
    		recipientDto.setAcadamyEndYear(endYear);
    		recipientDto.setAcadamyStartYear(startYear);
    		recipientDto.setFaculty1(facultyDto);
    		recipientDto.setSpecialized(specializedDto);
    		recipientDto.setClassRecipient(classRecipient);
    		campaignDto.setRecipient(recipientDto);
    		
    		Campaigns saveCampaign=campaignService.createCampaigns(campaignDto,files);
    		return ResponseEntity.ok(saveCampaign);
    		
    	} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error: "+e.getMessage());
		}
    	
    
    }
    
    @PostMapping ("/usercreate")
    public ResponseEntity<?> createCampaignByUser(@RequestParam ("campaignName") String campaignName,
    		@RequestParam("content") String content,
    		@RequestParam ("targetAmount") float targetAmount,
    		@RequestParam ("currentAmount") float currentAmount,
    		@RequestParam("userNameAccount") String userNameAccount  ,
    		@RequestParam("numberStudent") String numberStudent,
    		@RequestParam("fullName") String fullName,
    		@RequestParam("faculty") int faculty,
    		@RequestParam("specialized") int specialized,
    		@RequestParam("classRecipient") String classRecipient,
    		@RequestParam("startYear") String startYear,
    		@RequestParam("endYear") String endYear,
//    		@RequestParam ("endDate") String endDate,
    		@RequestParam ("endDateExpect") String endDateExpect,
    		@RequestParam ("status") int status,

    		@RequestParam("files") List<MultipartFile> files){
    	try {
    		Campaigns campaignDto=new Campaigns();
    		Recipient recipientDto=new Recipient();
    		Faculty facultyDto=new Faculty();
    		Specialized specializedDto=new Specialized();
    		campaignDto.setCampaignName(campaignName);
    		campaignDto.setContent(content);
    		campaignDto.setAccount2(AccountMapper.mapAccount(accountService.getAccountByUserName(userNameAccount)));
    		campaignDto.setTargetAmount(20000000);
    		campaignDto.setCurrentAmmout(currentAmount);
//    		campaignDto.setStartDate(startDate);
//    		campaignDto.setEndDate(endDate);
    		campaignDto.setEndDateExpect(endDateExpect);
    		campaignDto.setStatus(status);
    		facultyDto.setIdFaculty(faculty);
    		specializedDto.setIdSpecialized(specialized);
    		recipientDto.setFullName(fullName);
    		recipientDto.setNumberStudent(numberStudent);
    		recipientDto.setAcadamyEndYear(endYear);
    		recipientDto.setAcadamyStartYear(startYear);
    		recipientDto.setFaculty1(facultyDto);
    		recipientDto.setSpecialized(specializedDto);
    		recipientDto.setClassRecipient(classRecipient);
    		campaignDto.setRecipient(recipientDto);
    		
    		Campaigns saveCampaign=campaignService.createCampaigns(campaignDto,files);
    		return ResponseEntity.ok(saveCampaign);
    		
    	} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error: "+e.getMessage());
		}
    	
    
    }


  @GetMapping("/{id}")
  public ResponseEntity<CampaignsDto>getCampaign(@PathVariable("id") int id){
	  CampaignsDto campaign=campaignService.getCampaignById(id);
	  return ResponseEntity.ok(campaign);
  }
 @GetMapping("/image/{id}")
 public ResponseEntity<List<CampaignImagesDto>>getImage(@PathVariable("id") int id){
	 List<CampaignImagesDto>listImage=campaignImagesService.getCampaignImage(id);
	 return ResponseEntity.ok(listImage);
 }
 @PostMapping("/changestatus")
 public ResponseEntity<String>changeStatusCampaign(
		 @RequestParam ("status") int status, 
		 @RequestParam("idEmployee") int idEmployee,
		 @RequestParam ("id") int id,
		 @RequestParam("startDate") String startDate
		 )
 {
	String  changeStatus=campaignService.updateCampaignStatus(status,idEmployee, id, startDate);
	 return ResponseEntity.ok(changeStatus);
 }
 @GetMapping("getimagerepresent/{id}")
 public ResponseEntity<CampaignImagesDto>getRepresentImage(@PathVariable("id") int id){
	 CampaignImagesDto image=campaignImagesService.getRepresentImage(id);
	 return ResponseEntity.ok(image);
 }
	
 @PostMapping("/updatecurrentmoney")
 public ResponseEntity<String>updateCurrentMoney(
		 @RequestParam("money") Float money,
		 @RequestParam ("id") int id
		 ){
 String updateCurrentMoney=campaignService.UpdateCurrentMoneyCampaign(money, id);
 return ResponseEntity.ok(updateCurrentMoney);
 }
 
 @PostMapping("/changestatus/success")
 public ResponseEntity<String>changeStatusCampaignSuccess(
		 @RequestParam ("status") int status, 
		 @RequestParam("idEmployee") int idEmployee,
		 @RequestParam ("id") int id,
		 @RequestParam("endDate") String startDate
		 )
 {
	String  changeStatus=campaignService.updateCampaignStatus(status,idEmployee, id, startDate);
	 return ResponseEntity.ok(changeStatus);
 }
 @PutMapping("/updateCampaign")
 public ResponseEntity<String>updateCampaign(
		 @RequestParam ("campaignName") String campaignName,
 		@RequestParam("content") String content,
 		@RequestParam ("targetAmount") float targetAmount,
 		@RequestParam ("endDateExpect") String endDateExpect,
 		@RequestParam ("idCampaign") int id
		 ){
	 Campaigns campaign=new Campaigns();
	 campaign.setIdCampaign(id);
	 campaign.setCampaignName(campaignName);
	 campaign.setContent(content);
	 campaign.setTargetAmount(targetAmount);
	 campaign.setEndDateExpect(endDateExpect);
	 String updateCampaign=campaignService.updateCampaign(campaign);
	 return ResponseEntity.ok(updateCampaign);
 }
}
