package com.hospital.appointment.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;
    // EMAIL, SMS, PUSH

    @Column(name = "target_type", nullable = false)
    private String targetType;
    // DOCTOR, PATIENT

    /*Notification can be sent to either User or Doctor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
*/
    @Column(nullable = false, length = 500)
    private String message;

    @Column(nullable = false)
    private String status;
    // PENDING, SENT, FAILED

    @Column(name = "scheduled_at")
    private LocalDateTime scheduleAt;

    public Notification() {
    }
    

    public Notification(String type, String targetType, String message, String status, LocalDateTime scheduleAt) {
        this.type = type;
        this.targetType = targetType;
        this.message = message;
        this.status = status;
        this.scheduleAt = scheduleAt;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getScheduleAt() {
        return scheduleAt;
    }

    public void setScheduleAt(LocalDateTime scheduleAt) {
        this.scheduleAt = scheduleAt;
    }

    // getters and setters
    
}
