/*package com.health.appointment.system.hospital_appointment_booking_system.controller;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
import com.health.appointment.system.hospital_appointment_booking_system.repository.PatientRepository;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")  // Allows cross-origin requests, adjust if necessary
public class AppointmentController {

    @Autowired
    private PatientRepository patientRepository;

    // Endpoint to register a new patient using POST and @RequestBody
    @PostMapping("/register")
    public ResponseEntity<String> registerPatient(@RequestBody Patient patient) {
        try {
            // No need to parse again, assuming it's already a LocalDate
            patientRepository.save(patient);
            return ResponseEntity.ok("Patient successfully registered.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error occurred while registering patient: " + e.getMessage());
        }
    }

}*/
package com.health.appointment.system.hospital_appointment_booking_system.controller;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
import com.health.appointment.system.hospital_appointment_booking_system.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private PatientRepository patientRepository;

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

    // 3. Update doctor availability (dummy handler for now)
    @PostMapping("/doctors/updateAvailability")
    public ResponseEntity<String> updateAvailability(@RequestBody DoctorAvailabilityRequest request) {
        System.out.println("Doctor Name: " + request.getDoctorName());
        System.out.println("Availability: " + request.getAvailability());
        return ResponseEntity.ok("Doctor availability updated successfully!");
    }

}

