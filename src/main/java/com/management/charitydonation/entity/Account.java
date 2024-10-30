package com.management.charitydonation.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="account")
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_account")
public int idAccount;
@Column(name="user_name")
private String userName;
@Column (name="password")
private String password;
@Column (name="create_time",columnDefinition = "date")
private String createTime;
@Column (name="is_active",columnDefinition ="tinyint",length = 1)
private int isActive;


@ManyToOne 
@JoinColumn(name="id_role")
@EqualsAndHashCode.Exclude
private Role role;


@OneToOne (mappedBy = "account")
private User user;


@OneToOne (mappedBy = "account1")
private Employee employee;


@OneToMany (mappedBy = "account2")
private List<Campaigns>campaigns;


@OneToMany(mappedBy = "account3")
private List<Donations>donations;


}
