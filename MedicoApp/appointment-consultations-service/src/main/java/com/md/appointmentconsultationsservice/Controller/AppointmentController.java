package com.md.appointmentconsultationsservice.Controller;

import com.md.appointmentconsultationsservice.Clients.DoctorClient;
import com.md.appointmentconsultationsservice.Clients.PatientClient;
import com.md.appointmentconsultationsservice.Entities.Appointment;
import com.md.appointmentconsultationsservice.Model.Doctor;
import com.md.appointmentconsultationsservice.Model.Patient;
import com.md.appointmentconsultationsservice.Repository.AppointmentRepository;
import com.md.appointmentconsultationsservice.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private AppointmentService appointmentService;
    private final PatientClient patientClient;
    private final DoctorClient doctorClient;
    public AppointmentController(AppointmentService appointmentService,PatientClient patientClient, DoctorClient doctorClient) {
        this.appointmentService = appointmentService;
        this.patientClient = patientClient;
        this.doctorClient = doctorClient;
    }

    @GetMapping("/all")
    public List<Appointment> getAllAppointments(){
        return appointmentService.findAllAppointments();
    }

    @GetMapping("/find/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        return appointmentService.findAppointmentId(id);

    }

    @PostMapping("/create")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        System.out.println(appointment.getPatient_id());
        Patient patient = patientClient.getPatientById(appointment.getPatient_id());
        Doctor doctor = doctorClient.findById(appointment.getDoctor_id());
        if (patient == null || doctor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient or Doctor not found");
        }

        Appointment newAppointment = new Appointment();
        newAppointment.setPatient_id(appointment.getPatient_id());
        newAppointment.setDoctor_id(appointment.getDoctor_id());
        newAppointment.setDateRDV(appointment.getDateRDV());
        newAppointment.setHeureRDV(appointment.getHeureRDV());
        newAppointment.setConsultation(appointment.getConsultation());
        return appointmentService.saveAppointment(newAppointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return  appointmentService.updateAppointment(id, appointment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
