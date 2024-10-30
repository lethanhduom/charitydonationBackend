package com.management.charitydonation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.dto.EmployeeDto;
import com.management.charitydonation.service.AccountService;

import lombok.AllArgsConstructor;
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("api/account")
public class AccountController {
	private AccountService accountService;
	
	
	//thêm account bằng rest api
	@PostMapping
	public ResponseEntity<AccountDto>createAccount(@RequestBody AccountDto accountdto){
		AccountDto saveAccount= accountService.createAccount(accountdto);
		return new ResponseEntity<>(saveAccount,HttpStatus.CREATED);
	}
	@GetMapping("/getaccountactive")
	public ResponseEntity<List<AccountDto>>listAccountActive(){
	List<AccountDto>accountList=accountService.getAccountActive();
	return ResponseEntity.ok(accountList);
	}

}
