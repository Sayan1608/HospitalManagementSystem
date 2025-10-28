package com.hms.services;

import com.hms.entities.Department;
import com.hms.entities.Doctor;
import com.hms.repositories.DepartmentRepository;
import com.hms.repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Department assignDepartmentToDoctor(Department department, Long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        department.getDoctors().add(doctor);
        departmentRepository.save(department);
        return department;
    }
}
