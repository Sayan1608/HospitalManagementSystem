package com.hms.repositories;

import com.hms.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("select p from Patient p LEFT JOIN FETCH p.appointments ")
    List<Patient> getAllPatients();
}
