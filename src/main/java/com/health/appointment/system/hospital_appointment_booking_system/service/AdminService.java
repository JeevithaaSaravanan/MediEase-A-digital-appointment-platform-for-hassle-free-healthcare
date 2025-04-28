package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Admin;
import com.health.appointment.system.hospital_appointment_booking_system.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Fetch the current admin credentials
    public Admin getAdminCredentials() {
        return adminRepository.findByUsername("jee"); // Assuming 'jee' is your static admin username
    }

    // Update admin credentials
    public Admin updateAdminCredentials(String username, String password) {
        Admin admin = getAdminCredentials();
        if (admin != null) {
            admin.setUsername(username);
            admin.setPassword(password);
            return adminRepository.save(admin);
        }
        return null;
    }
}

