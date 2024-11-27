package com.management.charitydonation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.charitydonation.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.account.idAccount=?1")
	User getUserByIdAccount(int idAccount);
	

}
