package com.health.appointment.system.hospital_appointment_booking_system.repository;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
