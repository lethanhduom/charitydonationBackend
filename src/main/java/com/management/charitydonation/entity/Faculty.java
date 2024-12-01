package com.management.charitydonation.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_faculty")
	public int idFaculty;
	@Column(name="name_faculty",columnDefinition = "nvarchar(255)")
	String nameFaculty;
	@OneToMany(mappedBy ="faculty")
	List<Specialized>specializeds;
	 
	@OneToMany(mappedBy = "faculty1")
	List<Recipient>recipients;
	
	@OneToMany(mappedBy = "faculty2")
	List<Employee>employees;
	
	@OneToMany(mappedBy = "faculty3")
	List<User>users;

}
