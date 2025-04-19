package com.health.appointment.system.hospital_appointment_booking_system.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")  // Explicit root path mapping
public class HomeController {  // Renamed class to follow conventions

    @GetMapping
    public String home() {
        return "home";  // Still points to home.html in templates/
    }
}