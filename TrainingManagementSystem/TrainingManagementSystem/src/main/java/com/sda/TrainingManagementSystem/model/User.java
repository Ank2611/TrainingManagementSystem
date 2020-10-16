package com.sda.TrainingManagementSystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    @Enumerated(EnumType.STRING)
    private Type type;
    private String firstName;
    private String lastName;
    private boolean status;

    @OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParticipantRegistration> participantRegistrations= new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserNotification userNotification;


    public long getId() {
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

    public Type getType() {
        return type;
    }

    public void setType( Type type ) {
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

    public List<ParticipantRegistration> getParticipantRegistrations() {
        return participantRegistrations;
    }

    public void setParticipantRegistrations( List<ParticipantRegistration> participantRegistrations ) {
        this.participantRegistrations = participantRegistrations;
    }

    public UserNotification getUserNotification() {
        return userNotification;
    }

    public void setUserNotification( UserNotification userNotification ) {
        this.userNotification = userNotification;
    }
}
