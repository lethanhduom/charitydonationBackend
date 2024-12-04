package com.management.charitydonation.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.charitydonation.entity.Account;
import com.management.charitydonation.entity.User;


public interface AccountRepository extends JpaRepository<Account,Integer> {
	@Query("Select a From Account a ")
	List<Account> listAccountActive();
	boolean existsByuserName(String userName);
	Account findByuserName(String userName);
	@Query("Select a From Account a where a.userName=?1 and a.role.idRole=2")
	Account getAccount(String username);
	@Query ("select case When isActive =1 then true else false  end as isValid from Account a where a.userName=?1")
	boolean isActive (String userName);
	Account  findByUserNameAndPassword(String userName,String password);
    @Query ("Select a From Account a")
    Page<Account>getAllAccount(Pageable pageable);
    Account  findByIdAccount(int idAccount);
	
	
}
