package com.management.charitydonation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.management.charitydonation.entity.CampaignImages;

public interface CampaignImagesRepository extends JpaRepository<CampaignImages, Integer> {
  @Query("select c from CampaignImages c where campaign.idCampaign=?1")
  List<CampaignImages>getCampaignImageByIdCampaign(int id);
  
  @Query("select c from CampaignImages c where campaign.idCampaign=?1")
  Page<CampaignImages>getRepresentImage(int id,Pageable pageable);


}
