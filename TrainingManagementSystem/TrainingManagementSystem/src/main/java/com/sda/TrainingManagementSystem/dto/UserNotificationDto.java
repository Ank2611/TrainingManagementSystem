package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.Notification;
import com.sda.TrainingManagementSystem.model.User;

public class UserNotificationDto {
    private long id;
    private Notification readNotification;
    private Notification unreadNotification;
    private User user;

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public Notification getReadNotification() {
        return readNotification;
    }

    public void setReadNotification( Notification readNotification ) {
        this.readNotification = readNotification;
    }

    public Notification getUnreadNotification() {
        return unreadNotification;
    }

    public void setUnreadNotification( Notification unreadNotification ) {
        this.unreadNotification = unreadNotification;
    }

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }
}
