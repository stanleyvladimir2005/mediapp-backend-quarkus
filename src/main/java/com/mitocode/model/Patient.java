package com.mitocode.model;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private Integer idPatient;

    @Size(min = 3, message = "{first.name.size}")
    @Column(name = "first_name", length = 70)
    private String firstName;

    @Size(min = 3, message = "{last.name.size}")
    @Column(name = "last_name", length = 70)
    private String lastName;

    @Size(min = 9, max = 9, message = "{dui.size}")
    @Column(name = "dui", nullable = false, length = 9)
    private String dui;

    @Size(min = 3, max = 150, message = "{address.size}.")
    @Column(name = "address", length = 150)
    private String address;

    @Size(min = 8, max = 8, message = "{phone.size}.")
    @Column(name = "phone", length = 8)
    private String phone;

    @Email
    @Size(message = "{email.size}")
    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "status")
    private Boolean status;
}