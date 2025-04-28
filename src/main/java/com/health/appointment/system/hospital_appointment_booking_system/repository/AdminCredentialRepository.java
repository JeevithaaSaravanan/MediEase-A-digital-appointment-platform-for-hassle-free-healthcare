package com.health.appointment.system.hospital_appointment_booking_system.repository;

import com.health.appointment.system.hospital_appointment_booking_system.entity.AdminCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCredentialRepository extends JpaRepository<AdminCredential, Long> {
}
