package com.hospital.appointment.service;


import com.hospital.appointment.entity.Appointment;
import com.hospital.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Create an appointment
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get an appointment by ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    // Update an appointment
     public Appointment updateAppointment(Appointment appointment) {
        // Check if the appointment exists
        Optional<Appointment> existingAppointment = appointmentRepository.findById(appointment.getId());

        if (existingAppointment.isPresent()) {
            Appointment existing = existingAppointment.get();
            // Update the fields
            existing.setStartDateTime(appointment.getStartDateTime());
            existing.setEndDateTime(appointment.getEndDateTime());
            existing.setStatus(appointment.getStatus());
            // Save and return the updated entity
            return appointmentRepository.save(existing);
        }
        return null; // Or throw an exception if needed
    }

    // Delete an appointment
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
