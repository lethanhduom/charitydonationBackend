package com.management.charitydonation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.charitydonation.Response.ApiResponse;
import com.management.charitydonation.Response.AuthenticationResponse;
import com.management.charitydonation.Response.IntrospectReponse;
import com.management.charitydonation.Response.LoginResponse;
import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.dto.EmployeeDto;
import com.management.charitydonation.service.AccountService;
import com.management.charitydonation.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@AllArgsConstructor
@RestController
@RequestMapping("api/account")
public class AccountController {
	private AccountService accountService;
	private EmployeeService employeeService;
	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
	//thêm account bằng rest api
	@PostMapping
	public ResponseEntity<AccountDto>createAccount(@RequestBody AccountDto accountdto){
		AccountDto saveAccount= accountService.createAccount(accountdto);
		return new ResponseEntity<>(saveAccount,HttpStatus.CREATED);
	}

	@GetMapping("/getaccountactive")
	public ResponseEntity<Page<AccountDto>>listAccountActive(
			 @RequestParam(defaultValue = "0") int page,
	           @RequestParam(defaultValue = "5") int size
			){
			Page<AccountDto>accountList=accountService.getAccountActive(page, size);
			return ResponseEntity.ok(accountList);
	
	
	}
//	@PostMapping("/admin/login")
//	public ResponseEntity<LoginResponse>loginAdmin(@RequestParam String userName ,@RequestParam String password){
//		LoginResponse loginResponse=accountService.loginAdmin(userName,password);
//		return ResponseEntity.ok(loginResponse);
//	}
	@PostMapping("/login")
	public ResponseEntity<LoginResponse>login(@RequestBody AccountDto accountDto){
		LoginResponse loginResponse=accountService.login(accountDto);
		return ResponseEntity.ok(loginResponse);
	}
	
//	@PostMapping("/admin/login")
//	public ResponseEntity<T>
@PostMapping("/introspect")
public ResponseEntity<IntrospectReponse>authenticate(@RequestBody String token){
	var result=accountService.introspect(token);
	return ResponseEntity.ok(result);
}
@GetMapping("/getaccount/{username}")
public ResponseEntity<AccountDto>getAccountByUserName(@PathVariable ("username") String username){
	AccountDto account=accountService.getAccountByUserName(username);
	return ResponseEntity.ok(account);
}

@PostMapping("/google/authenticate")
public ResponseEntity<LoginResponse>googleAuthenticate(@RequestParam("code") String code){
	var result = accountService.googleAuthentication(code);
	return ResponseEntity.ok(result);
}

//@PostMapping("/google/authenticate")
//public ApiResponse<AuthenticationResponse>googleAuthenticate(@RequestParam("code") String code){
//	var result=accountService.outboundAuthentication(code);
//	 return ApiResponse.<AuthenticationResponse>builder().result(result).build();
//}


}
