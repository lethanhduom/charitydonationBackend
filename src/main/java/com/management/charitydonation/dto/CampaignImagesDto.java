package com.management.charitydonation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CampaignImagesDto {
	private int idImage;
	private String urlImage;
	private CampaignsDto campaigndto;
}
