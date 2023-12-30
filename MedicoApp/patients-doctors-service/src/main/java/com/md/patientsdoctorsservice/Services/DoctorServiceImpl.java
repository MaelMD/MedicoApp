package com.md.patientsdoctorsservice.Services;

import com.md.patientsdoctorsservice.Entities.Doctor;
import com.md.patientsdoctorsservice.Repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }
    @Override
    public Doctor findById(Long id){
        return doctorRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Patient not found"));
    }
    @Override
    public Doctor saveDoctor(Doctor doctor){
        Doctor doc = this.findById(doctor.getId());

        if(doc == null){
            return doctorRepository.save(doctor);
        }
        return null;
    }
    @Override
    public Doctor updateDoctor(Doctor doctor){
        Doctor doc = this.findById(doctor.getId());

        if(doc == null){
            return doctorRepository.save(doctor);
        }
        return null;
    }
    @Override
    public void deleteDoctor(Long id){
        Doctor doc = this.findById(id);
        if(doc != null){
            doctorRepository.deleteById(id);
        }
    }
}
