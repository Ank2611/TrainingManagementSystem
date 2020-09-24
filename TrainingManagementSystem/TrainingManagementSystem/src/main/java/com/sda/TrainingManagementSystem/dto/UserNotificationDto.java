package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.Notification;
import com.sda.TrainingManagementSystem.model.User;

import java.util.List;

public class UserNotificationDto {
    private long id;
    private List<NotificationDto> readNotificationDtoList;
    private List<NotificationDto> unreadNotificationDtoList;
    private UserDto userDto;

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public List<NotificationDto> getReadNotificationDtoList() {
        return readNotificationDtoList;
    }

    public void setReadNotificationDtoList( List<NotificationDto> readNotificationDtoList ) {
        this.readNotificationDtoList = readNotificationDtoList;
    }

    public List<NotificationDto> getUnreadNotificationDtoList() {
        return unreadNotificationDtoList;
    }

    public void setUnreadNotificationDtoList( List<NotificationDto> unreadNotificationDtoList ) {
        this.unreadNotificationDtoList = unreadNotificationDtoList;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto( UserDto userDto ) {
        this.userDto = userDto;
    }
}
