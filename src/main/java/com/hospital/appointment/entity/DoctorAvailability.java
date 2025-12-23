package com.hospital.appointment.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

@Entity
public class DoctorAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship with Doctor: A doctor has multiple availability slots
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @NotNull(message = "Doctor is required")  // Validate that the doctor is not null
    private Doctor doctor;

    @Column(nullable = false)
    @NotNull(message = "Start time is required")  // Ensure start time is not null
    @FutureOrPresent(message = "Start time must be in the present or future")  // Ensure the start time is not in the past
    private LocalDateTime startTime;

    @Column(nullable = false)
    @NotNull(message = "End time is required")  // Ensure end time is not null
    @FutureOrPresent(message = "End time must be in the present or future")  // Ensure the end time is not in the past
    private LocalDateTime endTime;

    @Column(nullable = false)
    private boolean available = true;

    public DoctorAvailability() {}

    public DoctorAvailability(Doctor doctor, LocalDateTime startTime, LocalDateTime endTime, boolean available) {
        this.doctor = doctor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.available = available;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Transient
    public String getTimeSlot(){
        return startTime + "-" + endTime;
    }

    public boolean overlaps(LocalDateTime checkStart,LocalDateTime checkEnd){
        return (startTime.isBefore(checkEnd)&&endTime.isAfter(checkStart));
    }
}
