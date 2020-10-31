package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.NotificationByClassesDto;
import com.sda.TrainingManagementSystem.dto.NotificationDto;

import java.util.List;

public interface NotificationService {
    NotificationDto getNotificationById(Long id);
    List<NotificationDto> getAll();
    void addNotification(NotificationDto notificationDto);
    void updateNotification(NotificationDto notificationDto);
    void deleteNotification(Long id);
    void addNewNotificationToClasses(NotificationDto notificationDto, Long id);
    List<NotificationByClassesDto> getAllNotificationByClasses(Long idClasses);
    List<NotificationDto> getAllReadNotification(Long id);
    List<NotificationDto> getAllUnreadNotification(Long id);
}
