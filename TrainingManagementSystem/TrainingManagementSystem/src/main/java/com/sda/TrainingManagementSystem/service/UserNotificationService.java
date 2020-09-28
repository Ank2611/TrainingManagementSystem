package com.sda.TrainingManagementSystem.service;


import com.sda.TrainingManagementSystem.dto.UserNotificationDto;

import java.util.List;

public interface UserNotificationService {
    UserNotificationDto getUserNotificationById( Long id);
    List<UserNotificationDto> getAll();
    void addUserNotification(UserNotificationDto userNotificationDto);
    void updateUserNotification(UserNotificationDto userNotificationDto);
    void deleteUserNotification(Long id);
    void notifyAcceptedUser(Long id);
    void UnreadToReadNotification(Long id, long notificationId);
}
