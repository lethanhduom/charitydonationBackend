package com.management.charitydonation.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_role")
private int idRole;
	@Column(name="role_name",columnDefinition = "nvarchar(255)")
private String roleName;
	
	
	@OneToMany(mappedBy = "role")
	private List<Account> account;
	
	
	@OneToMany (mappedBy = "role1")
	private List<DetailPermission>detailPermission;
}
