package com.mitocode.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name = "consult_detail")
public class ConsultDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail")
    private Integer idDetail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_consult", nullable = false)
    private Consult consult;

    @Column(name = "diagnosis", nullable = false, length = 70)
    private String diagnosis;

    @Column(name = "treatment", nullable = false, length = 300)
    private String treatment;
}