package com.health.appointment.system.hospital_appointment_booking_system.exception;

public class AppointmentConflictException extends RuntimeException {
    public AppointmentConflictException(String message) {
        super(message);
    }
}