package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
import com.health.appointment.system.hospital_appointment_booking_system.exception.PatientNotFoundException;
import com.health.appointment.system.hospital_appointment_booking_system.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        validatePatient(patient);
        return patientRepository.save(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Patient> getPatientById(Long id) throws PatientNotFoundException {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isEmpty()) {
            throw new PatientNotFoundException("Patient not found with ID: " + id);
        }
        return patient;
    }

    @Override
    public Patient updatePatient(Patient patient) throws PatientNotFoundException {
        if (!patientRepository.existsById(patient.getId())) {
            throw new PatientNotFoundException("Patient not found with ID: " + patient.getId());
        }
        validatePatient(patient);
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) throws PatientNotFoundException {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException("Patient not found with ID: " + id);
        }
        patientRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> findByAgeBetween(int minAge, int maxAge) {
        return patientRepository.findByAgeBetween(minAge, maxAge);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Patient> findByMobile(String mobile) {
        return patientRepository.findByMobile(mobile);
    }

    private void validatePatient(Patient patient) {
        if (patient.getName() == null || patient.getName().isBlank()) {
            throw new IllegalArgumentException("Patient name is required");
        }
        if (patient.getAge() < 0 || patient.getAge() > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120");
        }
        if (patient.getGender() == null || patient.getGender().isBlank()) {
            throw new IllegalArgumentException("Gender is required");
        }
        if (patient.getMobile() == null || patient.getMobile().isBlank()) {
            throw new IllegalArgumentException("Mobile number is required");
        }
    }
}