package com.management.charitydonation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.management.charitydonation.entity.Donations;

public interface DanationsRepository extends JpaRepository<Donations, Integer> {
@Query("select d from Donations d where campaign1.idCampaign=?1")
public Page<Donations>getDonations(int idCampaign, Pageable pageable);
@Query("select d from Donations d where campaign1.idCampaign=?1")
public List<Donations>getListDonationByIdCampaign(int idCampaign);
@Query("select d from Donations d where account3.idAccount=?1")
public Page<Donations>getDonationOfAccount(int id,Pageable pageable);

}
