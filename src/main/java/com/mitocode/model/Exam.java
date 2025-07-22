package com.mitocode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table (name = "exam")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_exam")
	private Integer idExam;
	
	@Column(name="exam_name", nullable= false, length=50)
	@Size(min=3, message="{examen_name.size}")
	private String examName;
	
	@Column(name="description", nullable= false, length=150)
	@Size(min=3, message="{examen_description.size}")
	private String description;

	@ManyToMany(mappedBy = "listExam",	fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Consult> consults;
	
	@Column(name = "status")
	private Boolean status;
}