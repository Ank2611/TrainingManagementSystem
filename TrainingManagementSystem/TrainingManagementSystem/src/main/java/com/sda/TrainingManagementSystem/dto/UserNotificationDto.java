package com.sda.TrainingManagementSystem.dto;

import java.util.List;

public class UserNotificationDto {
    private Long id;
    private List<NotificationDto> readNotificationDtoList;
    private List<NotificationDto> unreadNotificationDtoList;
    private UserDto userDto;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
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
