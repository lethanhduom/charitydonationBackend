package com.management.charitydonation.entity;



import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name ="specialized")
public class Specialized {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_specialized")
	public int idSpecialized;
	@Column (name="name_specialized",columnDefinition = "nvarchar(500)")
	public String nameSpecialized;
	@ManyToOne
	@JoinColumn(name="id_faculty")
	private Faculty faculty;
	
	@Nullable
	@OneToMany(mappedBy = "specialized")
	List<Recipient>recipients;
	
	@Nullable
	@OneToMany(mappedBy = "specialized1")
	List<User>users;
	

}
