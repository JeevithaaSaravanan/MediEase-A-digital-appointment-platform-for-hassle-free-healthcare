package com.health.appointment.system.hospital_appointment_booking_system.repository;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Finds patients by name (case-insensitive partial match)
     * @param name Partial or full name to search
     * @return List of matching patients
     */
    @Query("SELECT p FROM Patient p WHERE LOWER(p.name) LIKE LOWER(concat('%', :name, '%'))")
    List<Patient> searchByName(String name);

    /**
     * Finds a patient by exact mobile number
     * @param mobile The exact mobile number to search
     * @return Optional containing the patient if found
     */
    Optional<Patient> findByMobile(String mobile);

    /**
     * Finds patients within an age range
     * @param minAge Minimum age (inclusive)
     * @param maxAge Maximum age (inclusive)
     * @return List of patients in the age range
     */
    List<Patient> findByAgeBetween(int minAge, int maxAge);


    /**
     * Finds patients by gender
     * @param gender Gender to filter by (Male/Female/Other)
     * @return List of patients with matching gender
     */
    List<Patient> findByGender(String gender);
}