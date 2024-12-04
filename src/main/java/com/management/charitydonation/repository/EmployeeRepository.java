package com.management.charitydonation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.management.charitydonation.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
@Query("select e from Employee e where e.account1.idAccount=?1")
  Employee getEmployeeByIdAccount(int idAccount);
  
}
