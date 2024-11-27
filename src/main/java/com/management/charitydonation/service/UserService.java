package com.management.charitydonation.service;

import java.util.List;

import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.dto.UserDto;

public interface UserService {
UserDto createUser (UserDto userdto);
UserDto getUserById(int iduser);
List<UserDto>getAllUser();
UserDto updateUser (UserDto updateuser,int id);
UserDto UnActive (int id);
UserDto getUserByIdAccount(int idAccount);
}
