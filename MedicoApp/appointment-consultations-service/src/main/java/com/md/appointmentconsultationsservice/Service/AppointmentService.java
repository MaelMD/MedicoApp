package com.md.appointmentconsultationsservice.Service;

import com.md.appointmentconsultationsservice.Entities.Appointment;
import com.md.appointmentconsultationsservice.Entities.Consultation;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface AppointmentService {
    List<Appointment> findAllAppointments();

    Optional<Appointment> findAppointmentId(Long id);

    Appointment saveAppointment(Appointment appointment);

    Appointment updateAppointment(Long id, Appointment appointment);

    void deleteAppointment(Long id);
}
