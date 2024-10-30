package com.management.charitydonation.dto;

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
	private RoleDto roleDto;
}
