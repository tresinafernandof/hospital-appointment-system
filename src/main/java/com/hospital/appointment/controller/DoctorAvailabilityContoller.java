package com.hospital.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.appointment.entity.DoctorAvailability;
import com.hospital.appointment.service.DoctorAvailabilityService;

@RestController
@RequestMapping("/availability")
public class DoctorAvailabilityContoller {
    
    @Autowired
    private DoctorAvailabilityService doctorAvailabilityService;

    @PostMapping
    public DoctorAvailability createAvailability(@RequestBody DoctorAvailability doctorAvailability){
        return doctorAvailabilityService.saveAvailability(doctorAvailability);
    }

    @GetMapping
    public List<DoctorAvailability> getAllAvailability(){
        return doctorAvailabilityService.getAllAvailability();
    }

    @GetMapping("/{doctorId}")
    public List<DoctorAvailability> getByDoctor(@PathVariable Long doctorId){
        return doctorAvailabilityService.getAvailabilityByDoctor(doctorId);
    }

    // Update availability by ID
    @PutMapping("/{id}")
    public DoctorAvailability updateAvailability(@PathVariable Long id, @RequestBody DoctorAvailability doctorAvailability) {
        return doctorAvailabilityService.updateAvailability(id, doctorAvailability);
    }

    // Delete availability by ID
    @DeleteMapping("/{id}")
    public void deleteAvailability(@PathVariable Long id) {
        doctorAvailabilityService.deleteAvailability(id);
    }
}
