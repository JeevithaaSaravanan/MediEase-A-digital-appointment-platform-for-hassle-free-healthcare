package com.health.appointment.system.hospital_appointment_booking_system.controller;

public class DoctorAvailabilityRequest {
    private String doctorName;
    private String availability;

    // Getters and Setters
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
