package com.management.charitydonation.entity;

import jakarta.annotation.Nullable;
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
@Table(name="donations")
public class Donations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_donation")
private int idDonation;
	@Column (name="amount")
private float amount;
	@Column(name="donation_date",columnDefinition = "date")
private String donationDate;
	@Column(name="other",columnDefinition ="nvarchar(255)")
	@Nullable
private String other;
	
	@ManyToOne
	@JoinColumn(name="id_account")
	@EqualsAndHashCode.Exclude
	@Nullable
	private Account account3;
	
	@ManyToOne
	@JoinColumn(name="id_campaign")
	@EqualsAndHashCode.Exclude
	private Campaigns campaign1;

}
