package com.management.charitydonation.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.charitydonation.Response.LoginResponse;
import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.dto.CampaignsDto;
import com.management.charitydonation.dto.EmployeeDto;
import com.management.charitydonation.dto.UserDto;
import com.management.charitydonation.entity.Campaigns;
import com.management.charitydonation.service.AccountService;
import com.management.charitydonation.service.CampaignService;
import com.management.charitydonation.service.EmployeeService;
import com.management.charitydonation.service.UserService;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("api/admin")
public class EmployeeController {
	private EmployeeService employeeservice;
	private UserService userservice;
	private CampaignService campaignService;
	private AccountService accountService;
   @PostMapping("/createemployee")
   public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeedto){
	   EmployeeDto saveEmployee=employeeservice.createEmployee(employeedto);
	   return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
   }
   @GetMapping("/{id}")
   public ResponseEntity<EmployeeDto>getEmployee(@PathVariable ("id") int id){
	   EmployeeDto getEmployee=employeeservice.getEmployeeByIdAccount(id);
	   return ResponseEntity.ok(getEmployee);
   }
   @PostMapping("/createuser")
	public ResponseEntity<UserDto>createAccountUser(@RequestBody UserDto userdto){
		UserDto userdtocreate=userservice.createUser(userdto);
		return new ResponseEntity<>(userdtocreate,HttpStatus.CREATED);
	}
   @GetMapping ("/campaign")
	Page<CampaignsDto>getPage(
           @RequestParam(defaultValue = "0") int page,
           @RequestParam(defaultValue = "5") int size
   ) {
       return campaignService.getCampaign(page, size);
   }
@GetMapping("/count")
ResponseEntity<Long>getCountCampaign(){
	long countCampaign=campaignService.countCampaign();
	return ResponseEntity.ok(countCampaign);
}
@PostMapping("/login")
ResponseEntity<LoginResponse>loginAdmin(@RequestBody AccountDto accountDto){
	LoginResponse loginResponse=accountService.loginAdmin(accountDto);
	return ResponseEntity.ok(loginResponse);
}
@PostMapping("/temp")
ResponseEntity<LoginResponse>temp(@RequestParam String userName,@RequestParam String password){
	 AccountDto accountDto=new AccountDto();
	 accountDto.setUserName(userName);
	 accountDto.setPassword(password);
	 LoginResponse login=accountService.loginAdmin(accountDto);
      return ResponseEntity.ok(login);
}

	
}
