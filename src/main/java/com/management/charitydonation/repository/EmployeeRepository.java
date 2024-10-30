package com.management.charitydonation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.charitydonation.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
