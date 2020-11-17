package com.sda.TrainingManagementSystem.service;


import com.sda.TrainingManagementSystem.dto.UserNotificationDto;
import com.sda.TrainingManagementSystem.model.UserNotification;

import java.util.List;

public interface UserNotificationService {
    UserNotificationDto getUserNotificationById( Long id);
    List<UserNotificationDto> getAll();
    void addUserNotification(UserNotificationDto userNotificationDto);
    void updateUserNotification(UserNotificationDto userNotificationDto);
    void deleteUserNotification(Long id);
    void notifyAcceptedUser(UserNotificationDto userNotificationDto,Long id);
    void unreadToReadNotification(Long id, long notificationId);

}
