package com.management.charitydonation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.charitydonation.entity.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Integer> {

}
