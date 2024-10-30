package com.management.charitydonation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonationsDto {
	private int idDonation;
	private float amount;
	private String donationDate;
	private AccountDto accountDto;
	private CampaignsDto campaignDto;
	
}
