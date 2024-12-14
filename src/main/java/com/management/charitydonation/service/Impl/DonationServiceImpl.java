package com.management.charitydonation.service.Impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	@Override
	public Page<DonationsDto> getDonation(int idCampaign, int page, int size) {
		Page<Donations>getPage=donationRepository.getDonations(idCampaign, PageRequest.of(page, size));
		return getPage.map(donation->DonationMapper.mapDonationsDto(donation));
	}
	@Override
	public List<DonationsDto> getDonationByIdCampaign(int idCampaign) {
		List<Donations>getListDonation=donationRepository.getListDonationByIdCampaign(idCampaign);
		
		return getListDonation.stream().map(donation->DonationMapper.mapDonationsDto(donation)).toList();
	}
	@Override
	public Page<DonationsDto> getDonationShowUser(int id, int page, int size) {
		Page<Donations>getPage=donationRepository.getDonationOfAccount(id, PageRequest.of(page, size));
		return getPage.map(donation->DonationMapper.mapDonationsDto(donation));
	}

}
