package com.mitocode.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer idConsulta;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad especialidad;

    @JsonSerialize(using = ToStringSerializer.class) //Se agrega el formato ISO DATE
    private LocalDateTime fecha;

    //Relacion uno a  muchos
    @OneToMany(mappedBy = "consulta", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DetalleConsulta> detalleConsulta;

    @ManyToMany
    @JoinTable( name = "consulta_examen", joinColumns = @JoinColumn(name = "id_consulta"), inverseJoinColumns = @JoinColumn(name = "id_examen"))
    private List<Examen> listaExamen;
}