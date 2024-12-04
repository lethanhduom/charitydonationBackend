package com.management.charitydonation.service.Impl;

import org.springframework.stereotype.Service;

import com.management.charitydonation.dto.DonationsDto;
import com.management.charitydonation.entity.Donations;
import com.management.charitydonation.mapper.DonationMapper;
import com.management.charitydonation.repository.DanationsRepository;
import com.management.charitydonation.service.DonationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {
    
	private DanationsRepository donationRepository;
	@Override
	public DonationsDto createDonations(DonationsDto donationdto) {
		Donations donation=donationRepository.save(DonationMapper.mapDonations(donationdto));
		return DonationMapper.mapDonationsDto(donation);
	}

}
