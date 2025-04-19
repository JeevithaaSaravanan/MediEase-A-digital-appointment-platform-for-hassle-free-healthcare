package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Doctor;
import com.health.appointment.system.hospital_appointment_booking_system.exception.DoctorNotFoundException;
import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Optional<Doctor> getDoctorById(Long id) throws DoctorNotFoundException;
    Doctor updateDoctor(Doctor doctor) throws DoctorNotFoundException;
    void deleteDoctor(Long id) throws DoctorNotFoundException;
    List<Doctor> findBySpecialization(String specialization);
}