package com.management.charitydonation.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.management.charitydonation.dto.DonationsDto;

public interface DonationService {
DonationsDto createDonations (DonationsDto donationdto);
Page<DonationsDto>getDonation (int idCampaign,int page, int size);
List<DonationsDto>getDonationByIdCampaign(int idCampaign);
Page<DonationsDto>getDonationShowUser(int id,int page,int size);
}
