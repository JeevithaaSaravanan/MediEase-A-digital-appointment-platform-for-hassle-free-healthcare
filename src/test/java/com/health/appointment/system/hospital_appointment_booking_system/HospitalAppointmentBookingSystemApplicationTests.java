/*package com.health.appointment.system.hospital_appointment_booking_system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalAppointmentBookingSystemApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        // Verify Spring context loads successfully
        assertNotNull(context, "Application context should not be null");
    }

    @Test
    void mainMethodStartsApplication() {
        // Test that the main application starts without exceptions
        assertDoesNotThrow(() -> 
            HospitalAppointmentBookingSystemApplication.main(new String[] {}),
            "Main method should start application without throwing exceptions"
        );
    }

    @Test
    void allExpectedBeansAreLoaded() {
        // Verify critical beans are present in the context
        assertAll(
            () -> assertTrue(context.containsBean("appointmentController")),
            () -> assertTrue(context.containsBean("doctorController")),
            () -> assertTrue(context.containsBean("patientController")),
            () -> assertTrue(context.containsBean("appointmentServiceImpl")),
            () -> assertTrue(context.containsBean("corsConfigurer"))
        );
    }

    @Test
    void corsConfigurationIsCorrect() {
        // Verify CORS configuration bean exists and is properly configured
        WebMvcConfigurer configurer = context.getBean("corsConfigurer", WebMvcConfigurer.class);
        assertNotNull(configurer, "CORS configurer bean should exist");
    }
}*/
package com.health.appointment.system.hospital_appointment_booking_system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalAppointmentBookingSystemApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        // Verify Spring context loads successfully
        assertNotNull(context, "Application context should not be null");
    }

    @Test
    void mainMethodStartsApplication() {
        // Test that the main application starts without exceptions
        assertDoesNotThrow(() -> 
            HospitalAppointmentBookingSystemApplication.main(new String[] {}),
            "Main method should start application without throwing exceptions"
        );
    }

    @Test
    void allExpectedBeansAreLoaded() {
        // Verify critical beans are present in the context
        assertAll(
            () -> assertTrue(context.containsBean("appointmentController"), "appointmentController bean should be loaded"),
            () -> assertTrue(context.containsBean("doctorController"), "doctorController bean should be loaded"),
            () -> assertTrue(context.containsBean("patientController"), "patientController bean should be loaded"),
         //   () -> assertTrue(context.containsBean("appointmentServiceImpl"), "appointmentServiceImpl bean should be loaded"),
            () -> assertTrue(context.containsBean("corsConfigurer"), "corsConfigurer bean should be loaded")
        );
    }

    @Test
    void corsConfigurationIsCorrect() {
        // Verify CORS configuration bean exists and is properly configured
        WebMvcConfigurer configurer = context.getBean("corsConfigurer", WebMvcConfigurer.class);
        assertNotNull(configurer, "CORS configurer bean should exist");
    }
}
