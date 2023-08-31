package com.mitocode.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "media_file")
public class FileMedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_file")
	private int idFile;
	private String fileName;
	private String fileType;
	private byte[] value;
}