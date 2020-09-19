package com.sda.TrainingManagementSystem.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name="courseId")
    private Course course;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse( Course course ) {
        this.course = course;
    }
}
