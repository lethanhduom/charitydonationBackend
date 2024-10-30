package com.management.charitydonation.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.dto.UserDto;
import com.management.charitydonation.entity.User;
import com.management.charitydonation.exception.ResourceNotFoundException;
import com.management.charitydonation.mapper.AccountMapper;
import com.management.charitydonation.mapper.UserMapper;
import com.management.charitydonation.repository.UserRepository;
import com.management.charitydonation.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.NonFinal;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
private UserRepository userrepository;

@Override
public UserDto createUser(UserDto userdto) {
	   User user=UserMapper.mapUser(userdto);
	   User saveUser=userrepository.save(user);
	return UserMapper.mapUserDto(saveUser);
}

@Override
public UserDto getUserById(int iduser) {
	User  user=userrepository.findById(iduser).orElseThrow(()->
	new ResourceNotFoundException("User is not found")
	);
	return UserMapper.mapUserDto(user);
			}


@Override
public List<UserDto> getAllUser() {
	List<User>userlist=userrepository.findAll();
	
	return userlist.stream().map((user)->UserMapper.mapUserDto(user)).collect(Collectors.toList());
}

@Override
public UserDto updateUser(UserDto updateuser,int id) {
	
	User user= userrepository.findById(id).orElseThrow(()->
	new ResourceNotFoundException("user not found"));
	user.setAcadamyEndYear(updateuser.getAcadamyEndYear());
	user.setAcadamyStartYear(updateuser.getAcadamyStartYear());
//	user.setAccount(AccountMapper.mapAccount(updateuser.getAccount()));
	user.setAddress(updateuser.getAddress());
	user.setClassUser(updateuser.getClassUser());
	user.setFaculty(updateuser.getFaculty());
	user.setGender(updateuser.getGender());
	user.setEmail(updateuser.getEmail());
	user.setIdNumber(updateuser.getIdNumber());
	user.setPhoneNumber(updateuser.getPhoneNumber());
	User updateuserobj=userrepository.save(user);
	return UserMapper.mapUserDto(updateuserobj);
	
}

@Override
public UserDto UnActive(int id) {
	UserDto userdto=getUserById(id);
	User user=UserMapper.mapUser(userdto);
    user.getAccount().setIsActive(0);
    User userUnActive=userrepository.save(user);
    return UserMapper.mapUserDto(userUnActive);
	
}

}
