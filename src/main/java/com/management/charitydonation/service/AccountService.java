package com.management.charitydonation.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.management.charitydonation.Response.AuthenticationResponse;
import com.management.charitydonation.Response.IntrospectReponse;
import com.management.charitydonation.Response.LoginResponse;
import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.entity.Account;

public interface AccountService {
	public AccountDto createAccount(AccountDto accountdto);
	public AccountDto updateAccount(AccountDto accountDto, int id);
	public Page<AccountDto> getAccountActive(int page, int size);
	public LoginResponse loginAdmin(AccountDto accountDto);
	public LoginResponse login(AccountDto accountDto);
	public String generateToken(AccountDto accountDto);
	public IntrospectReponse introspect(String token);
	public AccountDto getAccount(int id);
	public AccountDto getAccountByUserName(String userName);
	public LoginResponse googleAuthentication(String code);
	 public AuthenticationResponse outboundAuthentication(String code);
	 public AccountDto getAccountByID(int id);
}
