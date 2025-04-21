package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
import com.health.appointment.system.hospital_appointment_booking_system.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        return optionalPatient.orElse(null);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> findByGender(String gender) {
        return patientRepository.findByGender(gender);
    }

    @Override
    public List<Patient> findByState(String state) {
        return patientRepository.findByState(state);
    }

    @Override
    public List<Patient> findByCity(String city) {
        return patientRepository.findByCity(city);
    }

    @Override
    public List<Patient> findByAge(int age) {
        return patientRepository.findByAge(age);
    }


    @Override
    public List<Patient> findByAlternateMobileNumber(String alternateMobileNumber) {
        return patientRepository.findByAlternateMobileNumber(alternateMobileNumber);
    }

    @Override
    public List<Patient> findByPayment(String payment) {
        return patientRepository.findByPayment(payment);
    }

    @Override
    public List<Patient> searchByName(String name) {
        return patientRepository.findByNameContainingIgnoreCase(name);
    }
  /*   @Override
    public List<Patient> findByAppointmentDate(LocalDate appointmentDate) {
        return patientRepository.findByAppointmentDate(appointmentDate);
    }*/
}
