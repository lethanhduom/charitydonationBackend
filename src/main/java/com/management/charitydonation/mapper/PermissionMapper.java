package com.management.charitydonation.mapper;

import com.management.charitydonation.dto.PermissionDto;
import com.management.charitydonation.entity.Permission;

public class PermissionMapper {
public static PermissionDto mapPermissionDto(Permission permission) {
	if(permission==null)
		return null;
	PermissionDto permissiondto=new PermissionDto();
	permissiondto.setIdPermission(permission.getIdPermission());
	permissiondto.setPermissionName(permission.getPermissionName());
	permissiondto.setIsActive(permission.getIsActive());
	return permissiondto;
}
public static Permission mapPermission (PermissionDto permissiondto) {
	if(permissiondto==null)
		return null;
	Permission permission=new Permission();
	permission.setIdPermission(permissiondto.getIdPermission());
	permission.setPermissionName(permissiondto.getPermissionName());
	permission.setIsActive(permissiondto.getIsActive());
	return permission;
	
}
}
