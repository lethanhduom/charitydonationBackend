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
@Table(name="permission")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_permission")
	private int idPermission;
	@Column(name="permission_name",columnDefinition = "nvarchar(255)")
	private String permissionName;
	@Column(name="is_active",columnDefinition = "tinyint",length = 1)
	private int isActive;
    @OneToMany(mappedBy = "permission")
    private List<DetailPermission>detailPermissions;
}
