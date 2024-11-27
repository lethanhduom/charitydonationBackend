package com.management.charitydonation.mapper;

import java.util.stream.Collectors;

import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.entity.Account;


public class AccountMapper {
public static AccountDto mapAccountDto(Account account) {
if(account==null) {
	return null;
}
AccountDto accountdto=new AccountDto();
accountdto.setIdAccount(account.getIdAccount());
accountdto.setUserName(account.getUserName());
accountdto.setCreateTime(account.getCreateTime());
accountdto.setPassword(account.getPassword());
accountdto.setIsActive(account.getIsActive());
accountdto.setPermit(account.getPermit());
accountdto.setRoleDto(RoleMapper.mapRoleDto(account.getRole()));
return accountdto;
}
public static Account mapAccount(AccountDto accountdto) {
	if(accountdto==null) {
		return null;
	}
	Account account=new Account();
	account.setIdAccount(accountdto.getIdAccount());
	account.setUserName(accountdto.getUserName());
	account.setCreateTime(accountdto.getCreateTime());
	account.setPassword(accountdto.getPassword());
	account.setIsActive(accountdto.getIsActive());
	account.setPermit(accountdto.getPermit());
	account.setRole(RoleMapper.maRole(accountdto.getRoleDto()));
	return account;
}

}
