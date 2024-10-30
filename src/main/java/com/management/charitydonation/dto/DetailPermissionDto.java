package com.management.charitydonation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailPermissionDto {
	private int idDetail;
	private String nameDetail;
	private RoleDto roleDto;
	private PermissionDto permissionDto;
	
}
