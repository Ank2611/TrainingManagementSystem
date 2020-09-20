package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.model.UserNotification;

import java.util.ArrayList;
import java.util.List;

public class NotificationDto {
    private Long id;
    private String subject;
    private String contents;
    private List<ClassesDto> classesDtos = new ArrayList<>();
    private List<UserNotificationDto> userNotificationDtoList = new ArrayList<>();
    private List<UserNotificationDto> userNotificationDtoList1 = new ArrayList<>();

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

    public List<ClassesDto> getClassesDtos() {
        return classesDtos;
    }

    public void setClassesDtos( List<ClassesDto> classesDtos ) {
        this.classesDtos = classesDtos;
    }

    public List<UserNotificationDto> getUserNotificationDtoList() {
        return userNotificationDtoList;
    }

    public void setUserNotificationDtoList( List<UserNotificationDto> userNotificationDtoList ) {
        this.userNotificationDtoList = userNotificationDtoList;
    }

    public List<UserNotificationDto> getUserNotificationDtoList1() {
        return userNotificationDtoList1;
    }

    public void setUserNotificationDtoList1( List<UserNotificationDto> userNotificationDtoList1 ) {
        this.userNotificationDtoList1 = userNotificationDtoList1;
    }
}
