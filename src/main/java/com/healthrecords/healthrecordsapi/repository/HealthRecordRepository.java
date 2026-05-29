package com.healthrecords.healthrecordsapi.repository;

import com.healthrecords.healthrecordsapi.entity.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {
    List<HealthRecord> findByPatientId(Long patientId);
    List<HealthRecord> findByDoctorId(Long doctorId);
}