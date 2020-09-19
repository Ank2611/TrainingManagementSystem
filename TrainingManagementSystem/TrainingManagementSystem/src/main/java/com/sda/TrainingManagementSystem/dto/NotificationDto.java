package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.model.UserNotification;

import java.util.ArrayList;
import java.util.List;

public class NotificationDto {
    private Long id;
    private String subject;
    private String contents;
    private List<Classes> classes = new ArrayList<>();
    private List<UserNotification> userNotificationList = new ArrayList<>();
    private List<UserNotification> userNotificationList1 = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject( String subject ) {
        this.subject = subject;
    }

    public String getContents() {
        return contents;
    }

    public void setContents( String contents ) {
        this.contents = contents;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses( List<Classes> classes ) {
        this.classes = classes;
    }

    public List<UserNotification> getUserNotificationList() {
        return userNotificationList;
    }

    public void setUserNotificationList( List<UserNotification> userNotificationList ) {
        this.userNotificationList = userNotificationList;
    }

    public List<UserNotification> getUserNotificationList1() {
        return userNotificationList1;
    }

    public void setUserNotificationList1( List<UserNotification> userNotificationList1 ) {
        this.userNotificationList1 = userNotificationList1;
    }
}
