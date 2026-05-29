package com.healthrecords.healthrecordsapi.repository;

import com.healthrecords.healthrecordsapi.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContainingIgnoreCase(String name);


    Optional<Patient> findByUserEmail(String email);
}