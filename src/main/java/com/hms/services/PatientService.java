package com.hms.services;

import com.hms.entities.Appointment;
import com.hms.entities.Doctor;
import com.hms.entities.Patient;
import com.hms.repositories.DoctorRepository;
import com.hms.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public void deletePatient(Long patientId){
        patientRepository.findById(patientId)
                .orElseThrow(()->new RuntimeException("Patient not found with id : " + patientId));
        patientRepository.deleteById(patientId);
    }

    @Transactional
    public Appointment bookAppointmentForAPatient(Appointment appointment, Long patientId, Long doctorId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id : " + patientId));

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        patient.getAppointments().add(appointment);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        return appointment;
    }


}
