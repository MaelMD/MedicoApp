package com.md.patientsdoctorsservice.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    private Long id;

    private String nom; // Name
    private String email;
    private String specialite; // Specialty

    @OneToMany

}
