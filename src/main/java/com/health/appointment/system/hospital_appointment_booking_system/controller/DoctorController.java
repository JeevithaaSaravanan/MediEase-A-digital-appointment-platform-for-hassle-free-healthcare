package com.health.appointment.system.hospital_appointment_booking_system.controller;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Doctor;
import com.health.appointment.system.hospital_appointment_booking_system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Save a new doctor
    @PostMapping
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    // Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    // Delete doctor by ID
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }

    // Get doctors by available time (e.g., "Morning", "Evening")
    @GetMapping("/availableTime/{availableTime}")
    public List<Doctor> getDoctorsByAvailableTime(@PathVariable String availableTime) {
        return doctorService.findByAvailableTime(availableTime);
    }

    // Search doctors by name (partial or full match)
    @GetMapping("/search/{name}")
    public List<Doctor> searchDoctorsByName(@PathVariable String name) {
        return doctorService.searchByName(name);
    }
}
