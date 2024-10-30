package com.management.charitydonation.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="detail_permission")
public class DetailPermission {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_detail")
	private int idDetail;
	@Column(name="name_detail",columnDefinition = "nvarchar(255)")
	private String nameDetail;
    @ManyToOne
    @JoinColumn(name="id_permission")
    @EqualsAndHashCode.Exclude
    private Permission permission;
    
    
    @ManyToOne
    @JoinColumn(name="id_role")
    @EqualsAndHashCode.Exclude
    private Role role1;
}
