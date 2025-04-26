package com.health.appointment.system.hospital_appointment_booking_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.health.appointment.system.hospital_appointment_booking_system.controller.DoctorAvailabilityRequest;
import com.health.appointment.system.hospital_appointment_booking_system.entity.Doctor;
import com.health.appointment.system.hospital_appointment_booking_system.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    @Transactional
    public boolean updateAvailability(DoctorAvailabilityRequest request) {
        try {
            String name = request.getDoctorName().trim();
            String availability = request.getAvailability();

            // Always create a new Doctor object (NO checking for existing doctor)
            Doctor doctor = new Doctor();
            doctor.setName(name);
            doctor.setAvailability(availability);

            doctorRepository.save(doctor);  // Always inserts new record

            System.out.println("Doctor inserted: " + doctor.getName() + " - " + doctor.getAvailability());
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
