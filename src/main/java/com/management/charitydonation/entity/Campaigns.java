package com.management.charitydonation.entity;

import java.util.List;

import org.hibernate.annotations.Type;

import jakarta.annotation.Nullable;
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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="campaigns")
public class Campaigns {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_campaign")
	private int idCampaign;
	@Column(name="campaign_name",columnDefinition = "nvarchar(255)")
	private String campaignName;
	@Column(name="content",columnDefinition = "LongText")
	private String content;
	@Column(name="target_amount")
	private float targetAmount;
	@Column(name="current_amount")
	private float currentAmmout;
	@Column(name="start_date",columnDefinition = "date")
	private String startDate;
	@Column(name="end_date",columnDefinition = "date")
	private String endDate;
	@Column(name="end_date_expect",columnDefinition = "date")
	private String endDateExpect;
	@Column(name="status")
	private int status;//0 mới gửi bải chờ duyệt, 1 đã duyệt, 2 không được duyệt ,3 là đã hoàn thành
	
	@ManyToOne
	@JoinColumn(name="id_account")
	@EqualsAndHashCode.Exclude
	@Nullable
	private Account account2;

	@OneToMany(mappedBy = "campaign",cascade = CascadeType.ALL)
	List< CampaignImages>campaignimages;
	
	
	@OneToMany(mappedBy = "campaign1")
	List<Donations>donations;
	
	
	@ManyToOne 
	@JoinColumn(name="id_employee")
	@EqualsAndHashCode.Exclude
	@Nullable
	private Employee employee;
	
	 @OneToOne (cascade = CascadeType.ALL)
	   @JoinColumn (name="id_recipient",referencedColumnName = "id_recipient")
	   private Recipient recipient;
	
//@Column(columnDefinition = "TEXT")//how to convert from string to long text
}
