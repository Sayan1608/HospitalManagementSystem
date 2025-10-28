package com.hms.services;

import com.hms.entities.Insurance;
import com.hms.entities.Patient;
import com.hms.repositories.InsuranceRepository;
import com.hms.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id : " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return insurance;
    }

    @Transactional
    public Patient updateInsuranceOfAPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id : " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;
    }

    @Transactional
    public Patient removeInsuranceOfAPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id : " + patientId));

        patient.setInsurance(null);
        return patient;
    }
}
