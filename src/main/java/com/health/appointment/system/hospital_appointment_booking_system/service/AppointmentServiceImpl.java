/*package com.health.appointment.system.hospital_appointment_booking_system.service;

import com.health.appointment.system.hospital_appointment_booking_system.entity.Appointment;
import com.health.appointment.system.hospital_appointment_booking_system.exception.AppointmentConflictException;
import com.health.appointment.system.hospital_appointment_booking_system.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) throws AppointmentConflictException {
        validateAppointment(appointment);
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) throws AppointmentConflictException {
        if (!appointmentRepository.existsById(appointment.getId())) {
            throw new IllegalArgumentException("Appointment not found");
        }
        validateAppointment(appointment);
        return appointmentRepository.save(appointment);
    }

    @Override
    public void cancelAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new IllegalArgumentException("Appointment not found");
        }
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public boolean isTimeSlotAvailable(Long doctorId, LocalDateTime dateTime) {
        return !appointmentRepository.existsByDoctorIdAndAppointmentDateTime(doctorId, dateTime);
    }

    private void validateAppointment(Appointment appointment) throws AppointmentConflictException {
        if (appointment.getDoctor() == null || appointment.getPatient() == null || 
            appointment.getAppointmentDateTime() == null) {
            throw new IllegalArgumentException("Required fields are missing");
        }
        
        if (!isTimeSlotAvailable(appointment.getDoctor().getId(), appointment.getAppointmentDateTime())) {
            throw new AppointmentConflictException(
                String.format("Doctor %s is not available at %s", 
                    appointment.getDoctor().getName(),
                    appointment.getAppointmentDateTime()));
        }
    }
}*/