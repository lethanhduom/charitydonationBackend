package com.management.charitydonation.service.Impl;



import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.dto.EmployeeDto;
import com.management.charitydonation.entity.Account;
import com.management.charitydonation.entity.Employee;
import com.management.charitydonation.enums.Permit;
import com.management.charitydonation.exception.UserAlreadyExistsException;
import com.management.charitydonation.mapper.AccountMapper;
import com.management.charitydonation.mapper.EmployeeMapper;
import com.management.charitydonation.repository.AccountRepository;
import com.management.charitydonation.repository.EmployeeRepository;
import com.management.charitydonation.repository.UserRepository;
import com.management.charitydonation.service.EmployeeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeerepository;
	private AccountRepository accountRepositoty;

	 private final PasswordEncoder passwordEncoder;
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeedto) {
	   if(accountRepositoty.existsByuserName(employeedto.getAccountDto().getUserName())) {
		   throw new UserAlreadyExistsException("USER_NAME_EXISTS");
	   }
	    HashSet<String>scope=new HashSet<>();
	   AccountDto accountDto=employeedto.getAccountDto();
	    Account account=AccountMapper.mapAccount(accountDto);
	    
		Employee employee=EmployeeMapper.mapEmployee(employeedto);
        account.setPassword(passwordEncoder.encode(employeedto.getAccountDto().getPassword()));
        
        if(employee.getAccount1().getRole().getIdRole()==2) {
        	scope.add(Permit.ADMIN.name());
        	scope.add(Permit.USER.name());
        	scope.add(Permit.LECTURE.name());
        account.setPermit(scope);
        }else {
        	scope.add(Permit.USER.name());
        	scope.add(Permit.LECTURE.name());
        	account.setPermit(scope);
        }
        employee.setAccount1(account);
		Employee saveEmployee=employeerepository.save(employee);
		return EmployeeMapper.mapEmployeeDto(saveEmployee);
	
	}
	@Override
	public EmployeeDto getEmployeeById(int id) {
		Employee getEmployee=employeerepository.getById(id);
		return EmployeeMapper.mapEmployeeDto(getEmployee);
	}
	@Override
	public EmployeeDto getEmployeeByIdAccount(int id) {
		Employee getEmployee=employeerepository.getEmployeeByIdAccount(id);
		return EmployeeMapper.mapEmployeeDto(getEmployee);
	}
	
	
	
	

}
