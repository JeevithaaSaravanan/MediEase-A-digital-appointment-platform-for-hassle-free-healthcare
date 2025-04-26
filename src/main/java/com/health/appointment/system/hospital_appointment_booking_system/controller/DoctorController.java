package com.health.appointment.system.hospital_appointment_booking_system.controller;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Doctor;
import com.health.appointment.system.hospital_appointment_booking_system.repository.DoctorRepository;
import com.health.appointment.system.hospital_appointment_booking_system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;  // Inject DoctorService

    // Endpoint to register doctor
    @PostMapping("/register")
    public ResponseEntity<String> registerDoctor(@RequestBody Doctor doctor) {
        try {
            // Save the doctor without checking if the doctor exists (allow duplicates)
            doctorRepository.save(doctor);
            return ResponseEntity.ok("Doctor added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while adding the doctor.");
        }
    }

    // Endpoint to get the latest doctor
    @GetMapping("/latest")
    public ResponseEntity<Doctor> getLatestDoctor() {
        try {
            Doctor doctor = doctorRepository.findTopByOrderByIdDesc();
            if (doctor != null) {
                return ResponseEntity.ok(doctor);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint to update doctor availability
    @PostMapping("/updateAvailability")
    public ResponseEntity<String> updateAvailability(@RequestBody DoctorAvailabilityRequest request) {
        boolean updated = doctorService.updateAvailability(request);

        if (updated) {
            return ResponseEntity.ok("Doctor availability updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating availability.");
        }
    }
}
