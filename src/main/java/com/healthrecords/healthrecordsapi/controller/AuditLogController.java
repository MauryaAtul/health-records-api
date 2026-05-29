package com.healthrecords.healthrecordsapi.controller;

import com.healthrecords.healthrecordsapi.entity.AuditLog;
import com.healthrecords.healthrecordsapi.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @GetMapping
    public List<AuditLog> getAllLogs() {
        return auditLogService.getAllLogs();
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<AuditLog>> getLogsByUser(@PathVariable String email) {
        return ResponseEntity.ok(auditLogService.getLogsByUser(email));
    }
}