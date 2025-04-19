package com.health.appointment.system.hospital_appointment_booking_system.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}