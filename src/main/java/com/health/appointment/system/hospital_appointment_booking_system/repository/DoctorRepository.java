
package com.health.appointment.system.hospital_appointment_booking_system.repository;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT d FROM Doctor d WHERE LOWER(d.name) = LOWER(:name)")
    Doctor findByNameIgnoreCase(@Param("name") String name);
    Doctor findTopByOrderByIdDesc();
}