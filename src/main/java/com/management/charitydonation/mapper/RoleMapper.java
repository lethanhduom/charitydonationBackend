package com.management.charitydonation.mapper;

import com.management.charitydonation.dto.RoleDto;
import com.management.charitydonation.entity.Role;

public class RoleMapper {
public static RoleDto mapRoleDto (Role role) {
	if(role==null) {
		return null;
	}
	RoleDto roledto=new RoleDto();
	roledto.setIdRole(role.getIdRole());
	roledto.setRoleName(role.getRoleName());
	return roledto;
}
public static Role maRole (RoleDto roledto) {
	if(roledto==null) {
		return null;
	}
	Role role=new Role();
	role.setIdRole(roledto.getIdRole());
	role.setRoleName(roledto.getRoleName());
	return role;
}
}
