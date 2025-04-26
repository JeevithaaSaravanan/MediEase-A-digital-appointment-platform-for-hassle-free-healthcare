package com.health.appointment.system.hospital_appointment_booking_system.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorAvailabilityRequest {

    private String doctorName;
    private String availability;

    // Default constructor is important for JSON deserialization
    public DoctorAvailabilityRequest() {
    }

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

    @Override
    public String toString() {
        return "DoctorAvailabilityRequest{" +
                "doctorName='" + doctorName + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}


    