package com.management.charitydonation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="campaign_images")
public class CampaignImages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_image")
	private int idImage;
	@Column(name="url_image")
	private String urlImage;
	@ManyToOne 
	@JoinColumn(name="id_campaign")
	private Campaigns campaign;

}
