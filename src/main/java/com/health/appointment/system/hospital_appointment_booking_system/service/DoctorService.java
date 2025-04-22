/*package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Doctor;

public interface DoctorService {
    Doctor updateAvailability(String doctorName, String availability);
}*/
package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.controller.DoctorAvailabilityRequest;

public interface DoctorService {
    boolean updateAvailability(DoctorAvailabilityRequest request);
}

