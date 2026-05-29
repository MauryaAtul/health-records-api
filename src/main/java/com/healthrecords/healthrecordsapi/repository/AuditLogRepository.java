package com.healthrecords.healthrecordsapi.repository;

import com.healthrecords.healthrecordsapi.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByUserEmail(String userEmail);
    List<AuditLog> findAllByOrderByTimestampDesc();
}