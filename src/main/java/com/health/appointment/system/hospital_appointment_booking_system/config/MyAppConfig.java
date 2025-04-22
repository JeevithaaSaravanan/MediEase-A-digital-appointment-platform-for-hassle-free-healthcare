
package com.health.appointment.system.hospital_appointment_booking_system.config;

import com.health.appointment.system.hospital_appointment_booking_system.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }
}
