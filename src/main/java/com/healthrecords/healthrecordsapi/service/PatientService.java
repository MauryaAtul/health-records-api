package com.healthrecords.healthrecordsapi.service;

import com.healthrecords.healthrecordsapi.dto.PatientDTO;
import com.healthrecords.healthrecordsapi.entity.Patient;
import com.healthrecords.healthrecordsapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.healthrecords.healthrecordsapi.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        return convertToDTO(patient);
    }

    public PatientDTO createPatient(PatientDTO dto) {
        Patient patient = convertToEntity(dto);
        Patient saved = patientRepository.save(patient);
        return convertToDTO(saved);
    }

    public PatientDTO updatePatient(Long id, PatientDTO dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        patient.setName(dto.getName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setGender(dto.getGender());
        patient.setPhone(dto.getPhone());
        patient.setAddress(dto.getAddress());
        patient.setBloodGroup(dto.getBloodGroup());
        return convertToDTO(patientRepository.save(patient));
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    private PatientDTO convertToDTO(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setGender(patient.getGender());
        dto.setPhone(patient.getPhone());
        dto.setAddress(patient.getAddress());
        dto.setBloodGroup(patient.getBloodGroup());
        return dto;
    }

    private Patient convertToEntity(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setGender(dto.getGender());
        patient.setPhone(dto.getPhone());
        patient.setAddress(dto.getAddress());
        patient.setBloodGroup(dto.getBloodGroup());
        return patient;
    }

    public PatientDTO getPatientByEmail(String email) {
        Patient patient = patientRepository.findByUserEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Patient profile not found for: " + email));
        return convertToDTO(patient);
    }
}