package com.management.charitydonation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.charitydonation.entity.Donations;

public interface DanationsRepository extends JpaRepository<Donations, Integer> {

}
