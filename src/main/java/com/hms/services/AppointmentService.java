package com.hms.services;

import com.hms.entities.Appointment;
import com.hms.entities.Doctor;
import com.hms.entities.Patient;
import com.hms.repositories.AppointmentRepository;
import com.hms.repositories.DoctorRepository;
import com.hms.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);
        return appointment;
    }

}
