package com.management.charitydonation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.charitydonation.entity.Account;


public interface AccountRepository extends JpaRepository<Account,Integer> {
	@Query("Select a From Account a where isActive=1")
	List<Account> listAccountActive();
	
}
