package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Doctor;
import com.health.appointment.system.hospital_appointment_booking_system.exception.DoctorNotFoundException;
import com.health.appointment.system.hospital_appointment_booking_system.repository.DoctorRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    private SessionFactory sessionFactory;

    // Constructor
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        validateDoctor(doctor);
        Doctor savedDoctor = doctorRepository.save(doctor);
        clearHibernateCache();  // Clearing cache after saving
        return savedDoctor;
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
        Doctor updatedDoctor = doctorRepository.save(doctor);
        clearHibernateCache();  // Clearing cache after update
        return updatedDoctor;
    }

    @Override
    public void deleteDoctor(Long id) throws DoctorNotFoundException {
        if (!doctorRepository.existsById(id)) {
            throw new DoctorNotFoundException("Doctor not found with ID: " + id);
        }
        doctorRepository.deleteById(id);
        clearHibernateCache();  // Clearing cache after delete
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findByAvailableTime(String availableTime) {
        return doctorRepository.findByAvailableTime(availableTime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> searchByName(String name) {
        return doctorRepository.searchByName(name);
    }

    private void validateDoctor(Doctor doctor) {
        if (doctor.getName() == null || doctor.getName().isBlank()) {
            throw new IllegalArgumentException("Doctor name is required");
        }
        if (doctor.getAvailableTime() == null || doctor.getAvailableTime().isBlank()) {
            throw new IllegalArgumentException("Available time is required");
        }
    }

    // Method to clear Hibernate cache
    private void clearHibernateCache() {
        Session session = sessionFactory.getCurrentSession();
        session.clear(); // Clears the first-level cache
    }
}
