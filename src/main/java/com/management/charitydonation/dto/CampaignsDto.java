package com.management.charitydonation.dto;

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
}
