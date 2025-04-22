package com.health.appointment.system.hospital_appointment_booking_system.controller;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
import com.health.appointment.system.hospital_appointment_booking_system.repository.PatientRepository;
import com.health.appointment.system.hospital_appointment_booking_system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorService doctorService;


    // 1. Register appointment
    @PostMapping("/register")
    public ResponseEntity<String> registerAppointment(@RequestBody Patient patient) {
        patientRepository.save(patient);
        return ResponseEntity.ok("Appointment registered successfully");
    }

    // 2. Get all appointments for admin panel
    @GetMapping("/appointments")
    public List<Patient> getAllAppointments() {
        return patientRepository.findAll();
    }

    // 3. Update doctor availability (handling the logic in service)
    @PostMapping("/doctors/updateAvailability")
    public ResponseEntity<String> updateAvailability(@RequestBody DoctorAvailabilityRequest request) {
        // Pass the entire request object to the service
        boolean success = doctorService.updateAvailability(request);
        if (!success) {
            return ResponseEntity.badRequest().body("Doctor not found or availability update failed");
        }
        return ResponseEntity.ok("Doctor availability updated successfully!");
    }
}
