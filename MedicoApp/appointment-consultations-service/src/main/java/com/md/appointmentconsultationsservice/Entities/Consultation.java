package com.md.appointmentconsultationsservice.Entities;

import jakarta.persistence.*;
import lombok.Data;

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
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateConsultation;

    private Date rapportConsultation;

    @OneToOne
    @JoinColumn(name = "rendezvous_id", referencedColumnName = "id")
    private Appointment appointment;
}
