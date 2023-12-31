package com.md.appointmentconsultationsservice.Clients;

import com.md.appointmentconsultationsservice.Model.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PATIENTS-DOCTORS-SERVICE", path = "/doctors")
public interface DoctorClient {
    @GetMapping("/find/{id}")
    Doctor findById(@PathVariable("id") Long id);
}
