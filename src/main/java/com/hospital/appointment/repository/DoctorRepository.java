package com.hospital.appointment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.appointment.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Custom queries can go here if needed (e.g., find by specialization)
    Doctor findByEmail(String email);
    Doctor findByPhone(String phone);
}