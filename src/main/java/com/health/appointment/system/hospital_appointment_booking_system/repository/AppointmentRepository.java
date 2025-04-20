/*package com.health.appointment.system.hospital_appointment_booking_system.repository;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    /**
     * Finds appointments by patient ID
     */
   // List<Appointment> findByPatientId(Long patientId);

    /**
     * Finds appointments by doctor ID
     */
    //List<Appointment> findByDoctorId(Long doctorId);

    /**
     * Finds appointments within a date range
     */
    //@Query("SELECT a FROM Appointment a WHERE a.appointmentDateTime BETWEEN :start AND :end")
    //List<Appointment> findAppointmentsBetweenDates(
      //      LocalDateTime start,
        //    LocalDateTime end
    //);

    /**
     * Checks if a time slot is already booked for a doctor
     */
   // boolean existsByDoctorIdAndAppointmentDateTime(Long doctorId, LocalDateTime appointmentDateTime);
//}