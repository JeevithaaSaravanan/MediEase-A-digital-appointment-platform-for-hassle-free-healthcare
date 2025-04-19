package com.health.appointment.system.hospital_appointment_booking_system.repository;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    /**
     * Finds doctors by their specialization
     * @param specialization The medical specialization to search for
     * @return List of doctors with matching specialization
     */
    List<Doctor> findBySpecializationContainingIgnoreCase(String specialization);

    /**
     * Finds a doctor by exact contact number
     * @param contact The exact contact number to search
     * @return Optional containing the doctor if found
     */
    Optional<Doctor> findByContact(String contact);

    /**
     * Searches doctors by name (case-insensitive partial match)
     * @param name Partial or full name to search
     * @return List of matching doctors
     */
    @Query("SELECT d FROM Doctor d WHERE LOWER(d.name) LIKE LOWER(concat('%', :name, '%'))")
    List<Doctor> searchByName(String name);

    /**
     * Finds available doctors by their available time slot
     * @param availableTime The time slot to check (e.g., "Morning")
     * @return List of doctors available at specified time
     */
    List<Doctor> findByAvailableTime(String availableTime);
}