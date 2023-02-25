package com.mitocode.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
@Entity
@Table(name = "consult")
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consult")
    private Integer idConsult;

    @ManyToOne
    @JoinColumn(name = "id_pacient", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_medic", nullable = false)
    private Medic medic;

    @ManyToOne
    @JoinColumn(name = "id_specialty", nullable = false)
    private Specialty specialty;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime consultDate;

    @OneToMany(mappedBy = "consult", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ConsultDetail> consultDetail;

    @ManyToMany
    @JoinTable( name = "consult_exam", joinColumns = @JoinColumn(name = "id_consult"), inverseJoinColumns = @JoinColumn(name = "id_exam"))
    private List<Exam> listExam;
}