package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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