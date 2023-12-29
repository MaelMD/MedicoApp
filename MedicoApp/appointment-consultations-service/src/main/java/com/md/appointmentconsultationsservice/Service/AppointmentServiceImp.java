package com.md.appointmentconsultationsservice.Service;

import com.md.appointmentconsultationsservice.Entities.Appointment;

import com.md.appointmentconsultationsservice.Repository.AppointmentRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

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
    public Optional<Appointment> findAppointmentId(Long id) {
        return this.appointmentRepository.findById(id);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return this.appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        return appointmentRepository.findById(id)
                .map(existingappointment -> {
                    existingappointment.setHeureRDV(appointment.getHeureRDV());
                    existingappointment.setDateRDV(appointment.getDateRDV());
                    existingappointment.setConsultation(appointment.getConsultation());
                    return appointmentRepository.save(existingappointment);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + id));
    }

    @Override
    public void deleteAppointment(Long id) {
        Appointment appointment= appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + id));
        appointmentRepository.delete(appointment);
    }


}
