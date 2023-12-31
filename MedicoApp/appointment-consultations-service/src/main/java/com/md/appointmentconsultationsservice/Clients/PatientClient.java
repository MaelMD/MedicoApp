package com.md.appointmentconsultationsservice.Clients;

import com.md.appointmentconsultationsservice.Model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PATIENTS-DOCTORS-SERVICE", path = "/patients")
public interface PatientClient {
    @GetMapping("/find/{id}")
    Patient getPatientById(@PathVariable("id") Long id);
}
