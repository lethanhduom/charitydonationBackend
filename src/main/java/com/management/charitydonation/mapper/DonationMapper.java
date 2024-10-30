package com.management.charitydonation.mapper;

import com.management.charitydonation.dto.DonationsDto;
import com.management.charitydonation.entity.Donations;

public class DonationMapper {
public static DonationsDto mapDonationsDto(Donations donation) {
	if(donation ==null) {
		return null;
	}
	DonationsDto donationdto=new DonationsDto();
	donationdto.setIdDonation(donation.getIdDonation());
	donationdto.setAmount(donation.getAmount());
	donationdto.setDonationDate(donation.getDonationDate());
	donationdto.setAccountDto(AccountMapper.mapAccountDto(donation.getAccount3()));
	donationdto.setCampaignDto(CampaignsMapper.mapCampaignsDto(donation.getCampaign1()));
	return donationdto;
}
public static Donations mapDonations (DonationsDto donationdto) {
	if(donationdto==null)
		return null;
	Donations donation=new Donations();
	donation.setIdDonation(donationdto.getIdDonation());
	donation.setAmount(donationdto.getAmount());
	donation.setDonationDate(donationdto.getDonationDate());
	donation.setAccount3(AccountMapper.mapAccount(donationdto.getAccountDto()));
	donation.setCampaign1(CampaignsMapper.mapCampaigns(donationdto.getCampaignDto()));
	return donation;
}
}
