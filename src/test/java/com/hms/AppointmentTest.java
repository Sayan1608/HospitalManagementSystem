package com.hms;

import com.hms.entities.Appointment;
import com.hms.services.PatientService;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void testBookPatientAppointment(){
        Appointment appointment = Appointment.builder()
                .reason("Fever")
                .appointmentTime(LocalDateTime.of(2025,10,29,13,20,0))
                .build();

        Appointment appointment1 = patientService.bookAppointmentForAPatient(appointment, 1L, 1L);
        System.out.println(appointment1);
        patientService.deletePatient(1L);
    }
}
