package com.healthrecords.healthrecordsapi.service;

import com.healthrecords.healthrecordsapi.entity.AuditLog;
import com.healthrecords.healthrecordsapi.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public void log(String userEmail, String action, String endpoint) {
        AuditLog log = new AuditLog(userEmail, action, endpoint);
        auditLogRepository.save(log);
    }

    public List<AuditLog> getAllLogs() {
        return auditLogRepository.findAllByOrderByTimestampDesc();
    }

    public List<AuditLog> getLogsByUser(String email) {
        return auditLogRepository.findByUserEmail(email);
    }
}