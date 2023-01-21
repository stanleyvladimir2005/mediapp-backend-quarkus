package com.mitocode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table (name = "examen")
@SQLDelete(sql = "UPDATE examen SET estado = false WHERE id_examen = ?")
@Where(clause = "estado = true")
public class Examen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_examen")
	private Integer idExamen;
	
	@Column(name="nombre", nullable= false, length=50)
	@Size(min=3, message="{examen_name.size}")
	private String nombre;
	
	@Column(name="descripcion", nullable= false, length=150)
	@Size(min=3, message="{examen_descripcion.size}")
	private String descripcion;

	@ManyToMany(mappedBy = "listaExamen",	fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Consulta> consultas;
	
	@Column(name = "estado")
	private Boolean estado;
}