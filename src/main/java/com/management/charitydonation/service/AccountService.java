package com.management.charitydonation.service;

import java.util.List;

import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.entity.Account;

public interface AccountService {
	public AccountDto createAccount(AccountDto accountdto);
	public AccountDto updateAccount(AccountDto accountDto, int id);
	public List<AccountDto> getAccountActive();
}
