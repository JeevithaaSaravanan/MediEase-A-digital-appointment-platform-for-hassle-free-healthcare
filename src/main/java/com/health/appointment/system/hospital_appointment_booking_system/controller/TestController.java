package com.health.appointment.system.hospital_appointment_booking_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/ping")
    public String ping() {
        return "PONG";
    }
}