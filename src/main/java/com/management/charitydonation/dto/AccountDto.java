package com.management.charitydonation.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	public int idAccount;
	private String userName;
	private String password;
	private String createTime;
	private int isActive;
	private Set<String> permit;
	private RoleDto roleDto;
	
	
}
