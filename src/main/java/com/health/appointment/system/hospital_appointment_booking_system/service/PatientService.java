package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
import com.health.appointment.system.hospital_appointment_booking_system.exception.PatientNotFoundException;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
    Optional<Patient> getPatientById(Long id) throws PatientNotFoundException;
    Patient updatePatient(Patient patient) throws PatientNotFoundException;
    void deletePatient(Long id) throws PatientNotFoundException;
    List<Patient> findByAgeBetween(int minAge, int maxAge);
    Optional<Patient> findByMobile(String mobile);
}