/*package com.health.appointment.system.hospital_appointment_booking_system.controller;
import com.health.appointment.system.hospital_appointment_booking_system.service.DoctorService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/updateAvailability")
    public ResponseEntity<String> updateAvailability(@RequestBody DoctorAvailabilityRequest request) {
        doctorService.updateAvailability(request.getDoctorName(), request.getAvailability());
        return ResponseEntity.ok("Availability updated successfully");
    }
}*/
package com.health.appointment.system.hospital_appointment_booking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.health.appointment.system.hospital_appointment_booking_system.service.DoctorService;  // Correct import

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/updateAvailability")
public ResponseEntity<String> updateDoctorAvailability(@RequestBody DoctorAvailabilityRequest request) {
    try {
        boolean success = doctorService.updateAvailability(request);

        if (success) {
            return ResponseEntity.ok("Doctor availability updated");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor not found or failed to update availability.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while updating doctor availability.");
    }
}
}