package com.management.charitydonation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.management.charitydonation.entity.Campaigns;

public interface CampaignsRepository extends JpaRepository<Campaigns, Integer> {
@Query("Select c from Campaigns c where c.status=?1")
Page<Campaigns>getCampaignPermit(int status,Pageable pageable);

}
