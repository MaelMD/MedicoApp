package com.md.appointmentconsultationsservice.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.md.appointmentconsultationsservice.Model.Doctor;
import com.md.appointmentconsultationsservice.Model.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date dateRDV;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "UTC")
    private Date heureRDV;
    @OneToOne
    private  Consultation consultation;
    @Transient
    private Doctor doctor;
    private Long doctor_id;
    @Transient
    private Patient patient;
    private Long patient_id;

}
