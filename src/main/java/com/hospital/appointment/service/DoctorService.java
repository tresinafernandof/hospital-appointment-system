package com.hospital.appointment.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.appointment.entity.Doctor;
import com.hospital.appointment.repository.DoctorRepository;

@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Create or update doctor
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Get doctor by ID
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Delete doctor by ID
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    //update doctor
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Optional<Doctor> existingDoctorOpt = doctorRepository.findById(id);
        if (existingDoctorOpt.isPresent()) {
            Doctor existingDoctor = existingDoctorOpt.get();
            existingDoctor.setFullName(updatedDoctor.getFullName());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
            existingDoctor.setEmail(updatedDoctor.getEmail());
            existingDoctor.setPhone(updatedDoctor.getPhone());
            return doctorRepository.save(existingDoctor);
        }
        return null;
    }

    // Patch: Update only provided fields
    public Doctor patchDoctor(Long id, Doctor partialDoctor) {
        Optional<Doctor> existingDoctorOpt = doctorRepository.findById(id);
        if (existingDoctorOpt.isPresent()) {
            Doctor existingDoctor = existingDoctorOpt.get();

            if (partialDoctor.getFullName() != null) {
                existingDoctor.setFullName(partialDoctor.getFullName());
            }
            if (partialDoctor.getSpecialization() != null) {
                existingDoctor.setSpecialization(partialDoctor.getSpecialization());
            }
            if (partialDoctor.getEmail() != null) {
                existingDoctor.setEmail(partialDoctor.getEmail());
            }
            if (partialDoctor.getPhone() != null) {
                existingDoctor.setPhone(partialDoctor.getPhone());
            }

            return doctorRepository.save(existingDoctor);
        }
        return null;
    }
    
    // Check if doctor exists by email or phone
    public boolean doctorExists(String email, String phone) {
        return doctorRepository.findByEmail(email) != null || doctorRepository.findByPhone(phone) != null;
    }
}
