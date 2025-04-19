package com.health.appointment.system.hospital_appointment_booking_system.exception;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message) {
        super(message);
    }
}