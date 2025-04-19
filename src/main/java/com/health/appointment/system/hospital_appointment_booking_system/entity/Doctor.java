package com.health.appointment.system.hospital_appointment_booking_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @NotBlank(message = "Available time is required")
    private String availableTime;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact must be 10 digits")
    private String contact;

    // Constructors
    public Doctor() {}

    public Doctor(String name, String specialization, String availableTime, String contact) {
        this.name = name;
        this.specialization = specialization;
        this.availableTime = availableTime;
        this.contact = contact;
    }

    // Getters and Setters (Keep if not using Lombok)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getAvailableTime() { return availableTime; }
    public void setAvailableTime(String availableTime) { this.availableTime = availableTime; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}