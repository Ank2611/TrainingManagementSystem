package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.ClassUnit;
import com.sda.TrainingManagementSystem.model.Notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassesDto {
    private Long id;
    private String subject;
    private Date date;
    private ClassUnit classUnit;
    private List<Notification> notificationList = new ArrayList<>();

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

    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }

    public ClassUnit getClassUnit() {
        return classUnit;
    }

    public void setClassUnit( ClassUnit classUnit ) {
        this.classUnit = classUnit;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList( List<Notification> notificationList ) {
        this.notificationList = notificationList;
    }
}
