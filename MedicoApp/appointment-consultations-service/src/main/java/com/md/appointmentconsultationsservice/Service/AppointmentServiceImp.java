package com.md.appointmentconsultationsservice.Service;

import com.md.appointmentconsultationsservice.Entities.Appointment;

import com.md.appointmentconsultationsservice.Entities.Consultation;
import com.md.appointmentconsultationsservice.Repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AppointmentServiceImp implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImp(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return this.appointmentRepository.findAll();
    }

    @Override
    public Appointment findAppointmentId(Long id) {
        return appointmentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Appointment not found"));
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return this.appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment appointment1=appointmentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Appointment not found"));
        appointment1.setDateRDV(appointment.getDateRDV());
        appointment1.setHeureRDV(appointment.getHeureRDV());
        return appointmentRepository.save(appointment1);}

    @Override
    public void deleteAppointment(Long id) {
        Appointment appointment= appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + id));
        appointmentRepository.delete(appointment);
    }


}
