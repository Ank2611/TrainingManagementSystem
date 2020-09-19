package com.sda.TrainingManagementSystem.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;

    @Enumerated(EnumType.STRING)
    private Type type;
    private String firstName;
    private String lastName;
    private boolean isActive;

    @OneToOne
    private ParticipantRegistration participantRegistration;

    @ManyToOne
    @JoinColumn(name="userId")
    private ClassUnit classUnit;

    public ParticipantRegistration getParticipantRegistration() {
        return participantRegistration;
    }

    public void setParticipantRegistration( ParticipantRegistration participantRegistration ) {
        this.participantRegistration = participantRegistration;
    }

    public ClassUnit getClassUnit() {
        return classUnit;
    }

    public void setClassUnit( ClassUnit classUnit ) {
        this.classUnit = classUnit;
    }

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive( boolean active ) {
        isActive = active;
    }
}
