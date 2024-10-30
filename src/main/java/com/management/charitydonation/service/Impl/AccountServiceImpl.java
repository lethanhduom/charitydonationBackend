package com.management.charitydonation.service.Impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.entity.Account;
import com.management.charitydonation.exception.ResourceNotFoundException;
import com.management.charitydonation.mapper.AccountMapper;
import com.management.charitydonation.repository.AccountRepository;
import com.management.charitydonation.service.AccountService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
	private AccountRepository accountRepository;

	@Override
	public AccountDto createAccount(AccountDto accountdto) {
		Account account=AccountMapper.mapAccount(accountdto);
		Account saveAccount = accountRepository.save(account);
		return AccountMapper.mapAccountDto(saveAccount);
	}

	@Override
	public AccountDto updateAccount(AccountDto accountDto, int id) {
		Account account=accountRepository.findById(id).orElseThrow(()
				->new ResourceNotFoundException("account not found"));
	
		account.setPassword(accountDto.getPassword());
		account.setUserName(accountDto.getUserName());
		Account saveAccount=accountRepository.save(account);
		return AccountMapper.mapAccountDto(saveAccount);
	}

	@Override
	public List<AccountDto> getAccountActive() {
		List<Account>accountList=accountRepository.listAccountActive();
		
		return accountList.stream().map(account->AccountMapper.mapAccountDto(account)).collect(Collectors.toList());
	}
	

}
