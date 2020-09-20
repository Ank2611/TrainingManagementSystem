package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.Notification;
import com.sda.TrainingManagementSystem.model.User;

public class UserNotificationDto {
    private long id;
    private NotificationDto readNotificationDto;
    private NotificationDto unreadNotificationDto;
    private UserDto userDto;

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public NotificationDto getReadNotificationDto() {
        return readNotificationDto;
    }

    public void setReadNotificationDto( NotificationDto readNotificationDto ) {
        this.readNotificationDto = readNotificationDto;
    }

    public NotificationDto getUnreadNotificationDto() {
        return unreadNotificationDto;
    }

    public void setUnreadNotificationDto( NotificationDto unreadNotificationDto ) {
        this.unreadNotificationDto = unreadNotificationDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto( UserDto userDto ) {
        this.userDto = userDto;
    }
}
