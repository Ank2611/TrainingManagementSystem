package com.sda.TrainingManagementSystem.dto;

import java.util.Date;

public class NotificationByClassesDto {
    private String classUnit_name;
    private String classes_subject;
    private Date classes_date;
    private String notification_subject;
    private String notification_contents;

    public NotificationByClassesDto( String classUnit_name, String classes_subject, Date classes_date,
                                     String notification_subject, String notification_contents ) {
        this.classUnit_name = classUnit_name;
        this.classes_subject = classes_subject;
        this.classes_date = classes_date;
        this.notification_subject = notification_subject;
        this.notification_contents = notification_contents;
    }

    public NotificationByClassesDto() {
    }

    public String getClassUnit_name() {
        return classUnit_name;
    }

    public void setClassUnit_name( String classUnit_name ) {
        this.classUnit_name = classUnit_name;
    }

    public String getClasses_subject() {
        return classes_subject;
    }

    public void setClasses_subject( String classes_subject ) {
        this.classes_subject = classes_subject;
    }

    public Date getClasses_date() {
        return classes_date;
    }

    public void setClasses_date( Date classes_date ) {
        this.classes_date = classes_date;
    }

    public String getNotification_subject() {
        return notification_subject;
    }

    public void setNotification_subject( String notification_subject ) {
        this.notification_subject = notification_subject;
    }

    public String getNotification_contents() {
        return notification_contents;
    }

    public void setNotification_contents( String notification_contents ) {
        this.notification_contents = notification_contents;
    }
}
