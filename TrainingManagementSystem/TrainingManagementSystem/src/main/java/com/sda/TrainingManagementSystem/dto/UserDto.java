package com.sda.TrainingManagementSystem.dto;


import java.util.List;

public class UserDto {
    private Long id;
    private String userName;
    private String password;
    private String type;
    private String firstName;
    private String lastName;
    private boolean status;
    private List<ParticipantRegistrationDto> participantRegistrationDtos;
    private UserNotificationDto userNotificationDto;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
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

    public String getType() {
        return type;
    }

    public void setType( String type ) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus( boolean status ) {
        this.status = status;
    }

    public List<ParticipantRegistrationDto> getParticipantRegistrationDtos() {
        return participantRegistrationDtos;
    }

    public void setParticipantRegistrationDtos( List<ParticipantRegistrationDto> participantRegistrationDtos ) {
        this.participantRegistrationDtos = participantRegistrationDtos;
    }

    public UserNotificationDto getUserNotificationDto() {
        return userNotificationDto;
    }

    public void setUserNotificationDto( UserNotificationDto userNotificationDto ) {
        this.userNotificationDto = userNotificationDto;
    }
}
