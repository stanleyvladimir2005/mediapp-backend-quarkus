package com.mitocode.model;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Data
@Entity
@Table(name = "specialty")
public class Specialty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_specialty")
	private Integer idSpecialty;
	
	@Column(name = "specialty_name", nullable = false, length = 50)
	@Size(min=3, message ="{specialty_name.size}")
	private String specialtyName;
	
	@Column(name = "status")
	private Boolean status;
}