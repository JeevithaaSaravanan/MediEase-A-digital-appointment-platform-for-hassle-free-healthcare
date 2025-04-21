package com.health.appointment.system.hospital_appointment_booking_system.controller;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
import com.health.appointment.system.hospital_appointment_booking_system.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Create a new Patient
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    // Get all patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Get patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update patient details
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            patient.setName(patientDetails.getName());
            patient.setAge(patientDetails.getAge());
            patient.setGender(patientDetails.getGender());
            patient.setCity(patientDetails.getCity());
            patient.setState(patientDetails.getState());
            patient.setMobile(patientDetails.getMobile());
            patient.setAlternateMobileNumber(patientDetails.getAlternateMobileNumber());
            patient.setPayment(patientDetails.getPayment());
          //  patient.setAppointmentDate(patientDetails.getAppointmentDate());
            
            Patient updatedPatient = patientService.savePatient(patient);
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete patient by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            patientService.deletePatientById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get patients by gender
    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Patient>> getPatientsByGender(@PathVariable String gender) {
        List<Patient> patients = patientService.findByGender(gender);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Get patients by state
    @GetMapping("/state/{state}")
    public ResponseEntity<List<Patient>> getPatientsByState(@PathVariable String state) {
        List<Patient> patients = patientService.findByState(state);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Get patients by city
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Patient>> getPatientsByCity(@PathVariable String city) {
        List<Patient> patients = patientService.findByCity(city);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    
    // Get patients by alternate mobile number
    @GetMapping("/alternate-mobile/{alternateMobileNumber}")
    public ResponseEntity<List<Patient>> getPatientsByAlternateMobileNumber(@PathVariable String alternateMobileNumber) {
        List<Patient> patients = patientService.findByAlternateMobileNumber(alternateMobileNumber);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Get patients by appointment date
/*    @GetMapping("/appointmentDate/{appointmentDate}")
    public ResponseEntity<List<Patient>> getPatientsByAppointmentDate(@PathVariable LocalDate appointmentDate) {
        List<Patient> patients = patientService.findByAppointmentDate(appointmentDate);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }*/
 


    // Get patients by payment method
     @GetMapping("/payment/{payment}")
    public ResponseEntity<List<Patient>> getPatientsByPayment(@PathVariable String payment) {
        List<Patient> patients = patientService.findByPayment(payment);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Search patients by name (case-insensitive)
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Patient>> searchPatientsByName(@PathVariable String name) {
        List<Patient> patients = patientService.searchByName(name);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}
/*package com.health.appointment.system.hospital_appointment_booking_system.controller;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Patient;
import com.health.appointment.system.hospital_appointment_booking_system.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Optional - needed if frontend access fails due to CORS
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            patient.setName(patientDetails.getName());
            patient.setAge(patientDetails.getAge());
            patient.setGender(patientDetails.getGender());
            patient.setCity(patientDetails.getCity());
            patient.setState(patientDetails.getState());
            patient.setMobile(patientDetails.getMobile());
            patient.setAlternateMobileNumber(patientDetails.getAlternateMobileNumber());
            patient.setPayment(patientDetails.getPayment());
            // patient.setAppointmentDate(patientDetails.getAppointmentDate());

            Patient updatedPatient = patientService.savePatient(patient);
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            patientService.deletePatientById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Patient>> getPatientsByGender(@PathVariable String gender) {
        List<Patient> patients = patientService.findByGender(gender);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<Patient>> getPatientsByState(@PathVariable String state) {
        List<Patient> patients = patientService.findByState(state);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Patient>> getPatientsByCity(@PathVariable String city) {
        List<Patient> patients = patientService.findByCity(city);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/alternate-mobile/{alternateMobileNumber}")
    public ResponseEntity<List<Patient>> getPatientsByAlternateMobileNumber(@PathVariable String alternateMobileNumber) {
        List<Patient> patients = patientService.findByAlternateMobileNumber(alternateMobileNumber);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/payment/{payment}")
    public ResponseEntity<List<Patient>> getPatientsByPayment(@PathVariable String payment) {
        List<Patient> patients = patientService.findByPayment(payment);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Patient>> searchPatientsByName(@PathVariable String name) {
        List<Patient> patients = patientService.searchByName(name);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}*/

