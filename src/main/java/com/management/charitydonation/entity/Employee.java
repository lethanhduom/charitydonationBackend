package com.management.charitydonation.entity;

import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name ="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_employee")
private int idEmployee;
	@Column(name="FullName",columnDefinition = "nvarchar(255)")
private String fullName;
	@Column(name="id_number")
private String idNumber;
	@Column(name="faculty",columnDefinition = "nvarchar(255)")
	@Nullable
private String faculty;
	@Column(name="gender")
private String gender;
	@Column(name="phone_number",columnDefinition = "nvarchar(10)")
private String phoneNumber;
	@Column(name="email")
private String email;
	@Column(name="address",columnDefinition = "nvarchar(255)")
private String address;
	@Column(name="date_of_birth")
private String dateOfBirth;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn (name="id_account",referencedColumnName = "id_account")
private Account account1;


@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
private List<Campaigns>campaigns;
}
