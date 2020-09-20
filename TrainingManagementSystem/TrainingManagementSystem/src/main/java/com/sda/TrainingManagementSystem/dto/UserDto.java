package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.ParticipantRegistration;
import com.sda.TrainingManagementSystem.model.UserNotification;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private long id;
    private String userName;
    private String password;
    private Enum type;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private ParticipantRegistration participantRegistration;
    private UserNotification userNotification;

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public Enum getType() {
        return type;
    }

    public void setType( Enum type ) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive( boolean active ) {
        isActive = active;
    }

    public ParticipantRegistration getParticipantRegistration() {
        return participantRegistration;
    }

    public void setParticipantRegistration( ParticipantRegistration participantRegistration ) {
        this.participantRegistration = participantRegistration;
    }

    public UserNotification getUserNotification() {
        return userNotification;
    }

    public void setUserNotification( UserNotification userNotification ) {
        this.userNotification = userNotification;
    }
}
