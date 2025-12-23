package com.hospital.appointment.service;

import java.util.List;

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
}