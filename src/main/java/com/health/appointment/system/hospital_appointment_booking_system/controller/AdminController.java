
package com.health.appointment.system.hospital_appointment_booking_system.controller;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Admin;
import com.health.appointment.system.hospital_appointment_booking_system.repository.AdminRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class AdminController {

   

    @Autowired
    private AdminRepository adminRepository;

    // Login handler
    @PostMapping("/AdminLoginServlet")
    public void handleAdminLogin(@RequestParam String username,
                                 @RequestParam String password,
                                 HttpServletResponse response) throws IOException {
        // Query the database for the admin based on username
        Admin admin = adminRepository.findByUsername(username);
        
        if (admin != null && admin.getPassword().equals(password)) {
            response.sendRedirect("/admin.html");
        } else {
            response.sendRedirect("/login.html?error=true");
        }
    }

    // Update admin credentials
    @PostMapping("/updateAdminCredentials")
    public ResponseEntity<String> updateCredentials(@RequestParam String newUsername, @RequestParam String newPassword) {
        try {
            // Assuming only one admin with id = 1
            Admin admin = adminRepository.findById(1L).orElse(null);

            if (admin == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
            }

            // Update admin details
            admin.setUsername(newUsername);
            admin.setPassword(newPassword); // In real-world, encrypt the password!

            adminRepository.save(admin);

            return ResponseEntity.ok("Credentials updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update credentials: " + e.getMessage());
        }
    }
}
