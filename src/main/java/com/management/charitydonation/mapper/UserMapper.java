package com.management.charitydonation.mapper;

import com.management.charitydonation.dto.UserDto;
import com.management.charitydonation.entity.User;

public class UserMapper {
public static UserDto mapUserDto(User user) {
	if(user==null)
		return null;
	UserDto userdto=new UserDto();
	userdto.setIdNumber(user.getIdNumber());
	userdto.setIdUser(user.getIdUser());
	userdto.setAcadamyStartYear(user.getAcadamyStartYear());
	userdto.setAcadamyEndYear(user.getAcadamyEndYear());
	userdto.setAddress(user.getAddress());
	
	userdto.setGender(user.getGender());
	userdto.setEmail(user.getEmail());
	userdto.setPhoneNumber(user.getPhoneNumber());
	userdto.setClassUser(user.getClassUser());
	userdto.setFullName(user.getFullName());
	userdto.setDateOfBirth(user.getDateOfBirth());
	userdto.setAccountDto(AccountMapper.mapAccountDto(user.getAccount()));
	return userdto;
}
public static User mapUser(UserDto userdto) {
	if(userdto==null)
		return null;
	User user=new User();
	user.setIdNumber(userdto.getIdNumber());
	user.setIdUser(userdto.getIdUser());
	user.setAcadamyStartYear(userdto.getAcadamyStartYear());
	user.setAcadamyEndYear(userdto.getAcadamyEndYear());
	user.setAddress(userdto.getAddress());
	
	user.setGender(userdto.getGender());
	user.setEmail(userdto.getEmail());
	user.setPhoneNumber(userdto.getPhoneNumber());
	user.setClassUser(userdto.getClassUser());
	user.setFullName(userdto.getFullName());
	user.setDateOfBirth(userdto.getDateOfBirth());
	user.setAccount(AccountMapper.mapAccount(userdto.getAccountDto()));
	return user;
}
}