package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
//import java.time.LocalDate;

import java.util.List;

public interface PatientService {

    Patient savePatient(Patient patient);

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    void deletePatientById(Long id);

    List<Patient> findByGender(String gender);

    List<Patient> findByState(String state);

    List<Patient> findByCity(String city);

    List<Patient> findByAge(int age);


    List<Patient> findByAlternateMobileNumber(String alternateMobileNumber);

    List<Patient> findByPayment(String payment);

    List<Patient> searchByName(String name);

  //  List<Patient> findByAppointmentDate(LocalDate appointmentDate);
}
