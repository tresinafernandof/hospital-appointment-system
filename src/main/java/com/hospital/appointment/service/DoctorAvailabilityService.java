package com.hospital.appointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.appointment.entity.DoctorAvailability;
import com.hospital.appointment.repository.DoctorAvailabilityRepository;

@Service
public class DoctorAvailabilityService {
    @Autowired
    private DoctorAvailabilityRepository doctorAvailabilityRepository;

    public DoctorAvailability saveAvailability(DoctorAvailability doctorAvailability){
        return doctorAvailabilityRepository.save(doctorAvailability);
    }

    public List<DoctorAvailability> getAllAvailability(){
        return  doctorAvailabilityRepository.findAll();
    }

    public List<DoctorAvailability> getAvailabilityByDoctor(Long doctorId){
        return  doctorAvailabilityRepository.findByDoctorId(doctorId);
    }

    public DoctorAvailability updateAvailability(Long id, DoctorAvailability doctorAvailability) {
        Optional<DoctorAvailability> existingAvailability = doctorAvailabilityRepository.findById(id);
        if (existingAvailability.isPresent()) {
            DoctorAvailability existing = existingAvailability.get();
            // Update fields as necessary
            existing.setStartTime(doctorAvailability.getStartTime());
            existing.setEndTime(doctorAvailability.getEndTime());
            existing.setDoctor(doctorAvailability.getDoctor());
            existing.setAvailable(doctorAvailability.isAvailable());
            // Save updated availability
            return doctorAvailabilityRepository.save(existing);
        }
        return null;  // Or throw an exception if not found
    }

    // Delete availability by ID
    public void deleteAvailability(Long id) {
        doctorAvailabilityRepository.deleteById(id);
    }
}