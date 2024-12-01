package com.management.charitydonation.mapper;

import com.management.charitydonation.dto.DetailPermissionDto;
import com.management.charitydonation.entity.DetailPermission;

public class DetailPermissionMapper {
public static DetailPermissionDto mapDetailPermissionDto (DetailPermission detail) {
	if(detail==null) {
		return null;
	}
	DetailPermissionDto detaildto=new DetailPermissionDto();
	detaildto.setIdDetail(detail.getIdDetail());
	detaildto.setNameDetail(detail.getNameDetail());
	detaildto.setRoleDto(RoleMapper.mapRoleDto(detail.getRole1()));
	detaildto.setPermissionDto(PermissionMapper.mapPermissionDto(detail.getPermission()));
	return detaildto;
}
public static DetailPermission mapDetailPermission (DetailPermissionDto detaildto) {
	if(detaildto==null)
		return null;
	DetailPermission detail=new DetailPermission();
	detail.setIdDetail(detaildto.getIdDetail());
	detail.setNameDetail(detaildto.getNameDetail());
	detail.setRole1(RoleMapper.maRole(detaildto.getRoleDto()));
	return detail;
}
}