package com.management.charitydonation.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.charitydonation.dto.EmployeeDto;
import com.management.charitydonation.dto.UserDto;
import com.management.charitydonation.entity.Employee;
import com.management.charitydonation.repository.EmployeeRepository;
import com.management.charitydonation.service.EmployeeService;
import com.management.charitydonation.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("account/user")
public class UserController {
	private UserService userservice;

	@PostMapping("/createuser")
	public ResponseEntity<UserDto>createAccountUser(@RequestBody UserDto userdto){
		UserDto userdtocreate=userservice.createUser(userdto);
		return new ResponseEntity<>(userdtocreate,HttpStatus.CREATED);
	}
	@GetMapping("{id}")
	public ResponseEntity<UserDto>findUserById(@PathVariable("id") int userid){
		UserDto finduser=userservice.getUserById(userid);
		return ResponseEntity.ok(finduser);
	}
   @GetMapping
   public ResponseEntity<List<UserDto>>findAllUser(){
	   List<UserDto>userdtolist=userservice.getAllUser();
	   return ResponseEntity.ok(userdtolist);
   }
   @PutMapping("/update/{id}")
   public ResponseEntity<UserDto>updateUser(@RequestBody UserDto userupdate,@PathVariable("id")int id){
	   UserDto userupdateobj=userservice.updateUser(userupdate, id);
	   return ResponseEntity.ok(userupdateobj);
   }
@PutMapping("/unactive/{id}")
public ResponseEntity<String>unActive(@PathVariable int id){
	userservice.UnActive(id);
	return ResponseEntity.ok("unactive successfull");
}

}
