package com.healthrecords.healthrecordsapi.controller;

import com.healthrecords.healthrecordsapi.dto.PatientDTO;
import com.healthrecords.healthrecordsapi.service.AuditLogService;
import com.healthrecords.healthrecordsapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AuditLogService auditLogService;

    @GetMapping
    public List<PatientDTO> getAllPatients(Authentication authentication) {
        auditLogService.log(authentication.getName(), "GET", "/api/patients");
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id, Authentication authentication) {
        auditLogService.log(authentication.getName(), "GET", "/api/patients/" + id);
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO dto, Authentication authentication) {
        auditLogService.log(authentication.getName(), "POST", "/api/patients");
        return ResponseEntity.ok(patientService.createPatient(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id, @RequestBody PatientDTO dto, Authentication authentication) {
        auditLogService.log(authentication.getName(), "PUT", "/api/patients/" + id);
        return ResponseEntity.ok(patientService.updatePatient(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id, Authentication authentication) {
        auditLogService.log(authentication.getName(), "DELETE", "/api/patients/" + id);
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    public ResponseEntity<PatientDTO> getMyProfile(Authentication authentication) {
        auditLogService.log(authentication.getName(), "GET", "/api/patients/me");
        return ResponseEntity.ok(patientService.getPatientByEmail(authentication.getName()));
    }
}