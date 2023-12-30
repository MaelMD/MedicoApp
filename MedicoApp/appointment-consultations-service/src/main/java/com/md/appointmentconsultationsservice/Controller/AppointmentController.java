package com.md.appointmentconsultationsservice.Controller;

import com.md.appointmentconsultationsservice.Entities.Appointment;
import com.md.appointmentconsultationsservice.Service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/all")
    public List<Appointment> getAllAppointments(){
        return appointmentService.findAllAppointments();
    }

    @GetMapping("/find/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        return appointmentService.findAppointmentId(id);

    }

    @PostMapping("/save")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
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
