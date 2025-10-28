package com.hms;

import com.hms.entities.Appointment;
import com.hms.entities.Insurance;
import com.hms.entities.Patient;
import com.hms.repositories.PatientRepository;
import com.hms.services.AppointmentService;
import com.hms.services.InsuranceService;
import com.hms.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private  AppointmentService appointmentService;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testAssignInsuranceToPatient(){
        Insurance insurance = Insurance.builder()
                .provider("ICICI LOMBARD")
                .validUntil(LocalDate.of(2027,10,1))
                .policyNumber("ICICLOMBARD1234")
                .build();

        insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(insurance);
//        patientService.deletePatient(1L);

        Patient patient = insuranceService.removeInsuranceOfAPatient(1L);
        System.out.println(patient);
    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,10,28,13,25,0))
                .reason("Diarroeha")
                .build();

        Appointment newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);
        System.out.println(newAppointment);
        patientService.deletePatient(1L);

    }

    @Test
    public void testNplusOneQueryOptimizations(){
        List<Patient> patients = patientRepository.getAllPatients();

        for(Patient p : patients){
            System.out.println(p);
        }
    }
}
