package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Doctor;
import com.health.appointment.system.hospital_appointment_booking_system.exception.DoctorNotFoundException;
import com.health.appointment.system.hospital_appointment_booking_system.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        validateDoctor(doctor);
        return doctorRepository.save(doctor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Doctor> getDoctorById(Long id) throws DoctorNotFoundException {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found with ID: " + id);
        }
        return doctor;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) throws DoctorNotFoundException {
        if (!doctorRepository.existsById(doctor.getId())) {
            throw new DoctorNotFoundException("Doctor not found with ID: " + doctor.getId());
        }
        validateDoctor(doctor);
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Long id) throws DoctorNotFoundException {
        if (!doctorRepository.existsById(id)) {
            throw new DoctorNotFoundException("Doctor not found with ID: " + id);
        }
        doctorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findBySpecialization(String specialization) {
        return doctorRepository.findBySpecializationContainingIgnoreCase(specialization);
    }

    private void validateDoctor(Doctor doctor) {
        if (doctor.getName() == null || doctor.getName().isBlank()) {
            throw new IllegalArgumentException("Doctor name is required");
        }
        if (doctor.getSpecialization() == null || doctor.getSpecialization().isBlank()) {
            throw new IllegalArgumentException("Specialization is required");
        }
        if (doctor.getContact() == null || doctor.getContact().isBlank()) {
            throw new IllegalArgumentException("Contact information is required");
        }
    }
}