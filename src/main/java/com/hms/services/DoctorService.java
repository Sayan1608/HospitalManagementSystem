package com.hms.services;

import com.hms.entities.Department;
import com.hms.entities.Doctor;
import com.hms.repositories.DepartmentRepository;
import com.hms.repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    @Transactional
    public void deleteDoctorById(Long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        List<Department> departments = departmentRepository.findAll();
        departments
                .forEach(department->department.getDoctors().remove(doctor));
        doctorRepository.deleteById(doctorId);
    }
}
