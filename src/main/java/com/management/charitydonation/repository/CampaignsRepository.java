package com.management.charitydonation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.management.charitydonation.dto.CampaignsDto;
import com.management.charitydonation.entity.Campaigns;

public interface CampaignsRepository extends JpaRepository<Campaigns, Integer> {
@Query("Select c from Campaigns c where c.status=?1")
Page<Campaigns>getCampaignPermit(int status,Pageable pageable);
@Modifying
@Transactional
@Query("Update Campaigns SET status=?1, employee.idEmployee=?2, startDate=?3 where idCampaign=?4")
int updateCampaign(int status, int idRecipient, String endDateExpect,int id);
Campaigns  findByIdCampaign(int idCampaign);

@Modifying
@Transactional
@Query("Update Campaigns c SET c.currentAmmout=c.currentAmmout+?1 where c.idCampaign=?2")
int updateCurrentMoney(Float money, int id);

@Modifying
@Transactional
@Query("Update Campaigns SET status=?1, employee.idEmployee=?2, endDate=?3 where idCampaign=?4")
int updateCampaignSucess(int status, int idEmployee, String endDate,int id);

@Modifying
@Transactional
@Query("Update Campaigns SET status=?1, endDate=?2 where idCampaign=?3")
int updateCampaignSucessUser(int status, String endDate,int id);


}
