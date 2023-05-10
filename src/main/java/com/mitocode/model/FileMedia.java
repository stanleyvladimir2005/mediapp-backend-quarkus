package com.mitocode.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "archivo")
public class FileMedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_archivo")
	private int idArchivo;
	private String filename;
	private String filetype;
	private byte[] value;
}