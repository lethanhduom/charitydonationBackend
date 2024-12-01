package com.management.charitydonation.dto;

import java.util.List;

import com.management.charitydonation.entity.Account;
import com.management.charitydonation.entity.CampaignImages;
import com.management.charitydonation.entity.Employee;
import com.management.charitydonation.entity.Recipient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CampaignsDto {
	private int idCampaign;
	private String campaignName;
	private String content;
	private float targetAmount;
	private float currentAmmout;
	private String startDate;
	private String endDate;
	private String endDateExpect;
	private int status;
	
   private AccountDto accountDto;
	private RecipientDto recipientDto;
	private EmployeeDto employeeDto;
	List< CampaignImages>campaignimages;
}
