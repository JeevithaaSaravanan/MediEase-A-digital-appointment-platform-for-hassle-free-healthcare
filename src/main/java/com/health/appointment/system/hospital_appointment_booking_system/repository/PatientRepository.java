package com.health.appointment.system.hospital_appointment_booking_system.repository;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByGender(String gender);

    List<Patient> findByState(String state);

    List<Patient> findByCity(String city);

    List<Patient> findByEmail(String email);

    List<Patient> findByAlternateMobileNumber(String alternateMobileNumber);

    List<Patient> findByPayment(String payment);

    List<Patient> findByNameContainingIgnoreCase(String name);

    List<Patient> findByAppointmentDate(LocalDate appointmentDate);
}
