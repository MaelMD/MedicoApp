package com.md.patientsdoctorsservice.Repositories;

import com.md.patientsdoctorsservice.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
