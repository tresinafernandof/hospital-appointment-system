package com.hospital.appointment.service;


import com.hospital.appointment.entity.Notification;
import com.hospital.appointment.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Create a notification
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // Get all notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Get a notification by ID
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    // Update a notification
    public Notification updateNotification(Notification notification) {
        // Check if the notification exists
        Optional<Notification> existingNotification = notificationRepository.findById(notification.getId());

        if (existingNotification.isPresent()) {
            Notification existing = existingNotification.get();
            // Update the fields
            existing.setType(notification.getType());
            existing.setTargetType(notification.getTargetType());
            existing.setMessage(notification.getMessage());
            existing.setStatus(notification.getStatus());
            existing.setScheduleAt(notification.getScheduleAt());
            // Save and return the updated entity
            return notificationRepository.save(existing);
        }
        return null; // Or throw an exception if needed
    }
    // Delete a notification
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}

