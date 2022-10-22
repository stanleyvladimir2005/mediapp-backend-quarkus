package com.mitocode.model;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "paciente")
@SQLDelete(sql = "UPDATE paciente SET estado = false WHERE id_paciente = ?")
@Where(clause = "estado = true")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Size(min = 3, message = "Los nombres deben tener entre 3-70 caracteres.")
    @Column(name = "nombres", nullable = true, length = 70)
    private String nombres;

    @Size(min = 3, message = "Los apellidos deben tener entre 3-70 caracteres.")
    @Column(name = "apellidos", nullable = true, length = 70)
    private String apellidos;

    @Size(min = 9, max = 9, message = "El dui debe tener 9 caracteres sin guiones.")
    @Column(name = "dui", nullable = false, length = 9)
    private String dui;

    @Size(min = 3, max = 150, message = "La direccion debe tener 150 caracteres.")
    @Column(name = "direccion", length = 150)
    private String direccion;

    @Size(min = 8, max = 8, message = "El telefono debe tener 8 caracteres sin guiones.")
    @Column(name = "telefono", length = 8)
    private String telefono;

    @Email
    @Size(message = "El correo debe tener 150 caracteres y en formato xxxxx@xxxx.xxx.")
    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "estado")
    private Boolean estado;
}