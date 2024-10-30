package com.management.charitydonation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.charitydonation.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer>{

}
