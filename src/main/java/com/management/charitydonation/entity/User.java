package com.management.charitydonation.entity;

import java.time.Year;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name ="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
private int idUser;
	@Column(name="id_number",columnDefinition = "varchar(20)")
	@Nullable
private String idNumber;
	@Column(name="gender",columnDefinition = "nvarchar(10)")
	@Nullable
private String gender;
	@Column(name="phone_number")
	@Nullable
private String phoneNumber;
	@Column(name="email")
private String email;
	@Column(name="acadamy_start_year",columnDefinition = "year")
	@Nullable
private Year acadamyStartYear;
	@Column(name="acadamy_end_year",columnDefinition = "year")
	@Nullable
private Year acadamyEndYear;
	@Column(name="class_user")
	@Nullable
private String classUser;
	@Nullable
	@Column(name="address",columnDefinition = "nvarchar(255)")
private String address;
	@Column(name="full_name")
private String fullName;
	@Nullable
	@Column(name="date_of_birth")
private String dateOfBirth;
	@Nullable
   @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn (name="id_account",referencedColumnName = "id_account")
   private Account account;
   
   @Nullable
   @ManyToOne
   @JoinColumn(name="id_faculty")
   private Faculty faculty3;
   
   @Nullable
   @ManyToOne
   @JoinColumn(name="id_specialized")
   private Specialized specialized1;

}
