package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.Course;
import com.sda.TrainingManagementSystem.model.User;

import java.util.Date;

public class ParticipantRegistrationDto {
    private Long id;
    private Date date;
    private UserDto userDto;
    private CourseDto courseDto;

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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto( UserDto userDto ) {
        this.userDto = userDto;
    }

    public CourseDto getCourseDto() {
        return courseDto;
    }

    public void setCourseDto( CourseDto courseDto ) {
        this.courseDto = courseDto;
    }
}
