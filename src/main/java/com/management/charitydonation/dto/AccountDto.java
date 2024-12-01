package com.management.charitydonation.dto;

import java.util.List;
import java.util.Set;

import com.management.charitydonation.entity.Campaigns;
import com.management.charitydonation.entity.Donations;
import com.management.charitydonation.entity.Employee;
import com.management.charitydonation.entity.Role;
import com.management.charitydonation.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
	private UserDto userDto;
	private EmployeeDto employeeDto;
	
}
