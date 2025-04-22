/*package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Appointment;
import com.health.appointment.system.hospital_appointment_booking_system.exception.AppointmentConflictException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment) throws AppointmentConflictException;
    List<Appointment> getAllAppointments();
    Optional<Appointment> getAppointmentById(Long id);
    Appointment updateAppointment(Appointment appointment) throws AppointmentConflictException;
    void cancelAppointment(Long id);
    List<Appointment> getAppointmentsByPatientId(Long patientId);
    List<Appointment> getAppointmentsByDoctorId(Long doctorId);
    boolean isTimeSlotAvailable(Long doctorId, LocalDateTime dateTime);
}*/
/*package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
import java.util.List;

public interface AppointmentService {
    List<Patient> getAllAppointments(); // Ensure that this method signature is correct and functional
}*/
