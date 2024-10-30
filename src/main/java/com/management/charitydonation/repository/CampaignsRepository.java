package com.management.charitydonation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.charitydonation.entity.Campaigns;

public interface CampaignsRepository extends JpaRepository<Campaigns, Integer> {

}
