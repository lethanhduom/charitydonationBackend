package com.management.charitydonation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.management.charitydonation.entity.Faculty;
import com.management.charitydonation.entity.Specialized;

public interface SpecializedRepository extends JpaRepository<Specialized, Integer> {

@Query("select s from Specialized s where faculty.idFaculty=?1")
List<Specialized>getByFacultyId(int id);
}
