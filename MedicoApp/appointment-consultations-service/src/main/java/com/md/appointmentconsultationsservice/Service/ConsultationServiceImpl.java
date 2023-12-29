package com.md.appointmentconsultationsservice.Service;

import com.md.appointmentconsultationsservice.Entities.Consultation;
import com.md.appointmentconsultationsservice.Repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationServiceImpl(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public List<Consultation> findAllConsultations() {
        return consultationRepository.findAll();
    }

    @Override
    public Optional<Consultation> findConsultationById(Long id) {
        return consultationRepository.findById(id);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation updateConsultation(Long id, Consultation consultation) {
        return consultationRepository.findById(id)
                .map(existingConsultation -> {
                    existingConsultation.setDateConsultation(consultation.getDateConsultation());
                    existingConsultation.setRapportConsultation(consultation.getRapportConsultation());
                    existingConsultation.setAppointment(consultation.getAppointment());
                    return consultationRepository.save(existingConsultation);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Consultation not found with id " + id));
    }

    @Override
    public void deleteConsultation(Long id) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consultation not found with id " + id));
        consultationRepository.delete(consultation);
    }
}
