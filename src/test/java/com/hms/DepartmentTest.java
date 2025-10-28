package com.hms;

import com.hms.entities.Department;
import com.hms.entities.Doctor;
import com.hms.repositories.DoctorRepository;
import com.hms.services.DepartmentService;
import com.hms.services.DoctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentTest {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    public void testAssignDepartmentToDoctor(){
        Department department = Department.builder()
                .name("Cardiology")
                .hod(doctorRepository.findById(2L).orElseThrow())
                .build();

        Department department1 = departmentService.assignDepartmentToDoctor(department, 1L);
        System.out.println(department1);
        testRemoveDoctor();
    }

    @Test
    public void testRemoveDoctor(){
        doctorService.deleteDoctorById(1L);
    }
}
