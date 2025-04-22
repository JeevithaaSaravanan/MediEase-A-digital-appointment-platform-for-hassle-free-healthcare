/*package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Doctor;
import com.health.appointment.system.hospital_appointment_booking_system.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // Mark this class as a Spring Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor updateAvailability(String doctorName, String availability) {
        // Find the doctor by their name
        Doctor doctor = doctorRepository.findByName(doctorName);
        if (doctor != null) {
            // Update the availability of the doctor
            doctor.setAvailability(availability);
            // Save the updated doctor back into the database
            doctorRepository.save(doctor);
        }
        return doctor;  // Return the updated doctor or null if not found
    }
}*/
package com.health.appointment.system.hospital_appointment_booking_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.appointment.system.hospital_appointment_booking_system.controller.DoctorAvailabilityRequest;  // Correct import for DTO
import com.health.appointment.system.hospital_appointment_booking_system.entity.Doctor;
import com.health.appointment.system.hospital_appointment_booking_system.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public boolean updateAvailability(DoctorAvailabilityRequest request) {
        try {
            Doctor doctor = doctorRepository.findByNameIgnoreCase(request.getDoctorName());

            if (doctor != null) {
                doctor.setAvailability(request.getAvailability());
                doctorRepository.save(doctor);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
