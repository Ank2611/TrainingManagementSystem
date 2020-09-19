package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.Course;
import com.sda.TrainingManagementSystem.model.User;

import java.util.Date;

public class ParticipantRegistrationDto {
    private Long id;
    private Date date;
    private User user;
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse( Course course ) {
        this.course = course;
    }
}
