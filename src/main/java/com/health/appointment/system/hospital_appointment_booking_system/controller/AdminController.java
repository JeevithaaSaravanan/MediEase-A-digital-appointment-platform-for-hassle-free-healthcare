/*package com.health.appointment.system.hospital_appointment_booking_system.controller;

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
}*/
/*package com.health.appointment.system.hospital_appointment_booking_system.controller;

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
            // Redirect to static HTML correctly
            response.sendRedirect("/admin.html");
        } else {
            response.sendRedirect("/login.html?error=true");
        }
    }

    // Make sure this mapping exists if direct URL access fails
    @GetMapping("/admin.html")
    public String redirectAdminPage() {
        return "forward:/admin.html";
    }
}*/

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
    try {
        if ("jee".equals(username) && "es21cj15".equals(password)) {
            response.sendRedirect("/admin.html");
        } else {
            response.sendRedirect("/login.html?error=true");
        }
    } catch (Exception e) {
        e.printStackTrace(); // Log error in console
        response.sendRedirect("/login.html?error=true");
    }
    }
}

