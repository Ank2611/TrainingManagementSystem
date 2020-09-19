package com.sda.TrainingManagementSystem.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="registration")
public class ParticipantRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")
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
