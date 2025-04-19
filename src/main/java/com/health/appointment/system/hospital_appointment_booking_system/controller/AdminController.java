package com.health.appointment.system.hospital_appointment_booking_system.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class AdminController {

    @PostMapping("/AdminLoginServlet")
    public void handleAdminLogin(@RequestParam String username,
                                 @RequestParam String password,
                                 HttpServletResponse response) throws IOException {

        if ("admin".equals(username) && "12345".equals(password)) {
            response.sendRedirect("/admin.html");
        } else {
            response.sendRedirect("/login.html?error=true");
        }
    }
}
