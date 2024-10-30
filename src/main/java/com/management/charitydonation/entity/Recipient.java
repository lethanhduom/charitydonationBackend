package com.management.charitydonation.entity;

import java.time.Year;
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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="recipient")
public class Recipient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_recipient")
	private int idRecipient;
	@Column(name="number_student")
	private String numberStudent;
	@Column(name = "full_name",columnDefinition = "nvarchar(255)")
	private String fullName;
	@Column(name = "faculty",columnDefinition = "nvarchar(255)")
	private String faculty;
	@Column(name = "specialized",columnDefinition = "nvarchar(255)")
	@Getter
	private String specialized;
	@Column(name = "class_recipient",columnDefinition = "nvarchar(255)")
	private String classRecipient;
	@Column(name="acadamy_start_year",columnDefinition = "year")
private Year acadamyStartYear;
	@Column(name="acadamy_end_year",columnDefinition = "year")
private Year acadamyEndYear;
    	
	@OneToOne(mappedBy = "recipient")
	public Campaigns campaign;

	

}
