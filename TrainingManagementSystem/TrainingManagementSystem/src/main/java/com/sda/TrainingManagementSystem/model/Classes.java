package com.sda.TrainingManagementSystem.model;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ClassUnit classUnit;

    @ManyToMany(mappedBy = "classes", cascade = CascadeType.ALL)
    private List<Notification> notificationList = new ArrayList<>();

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

    public ClassUnit getClassUnit() {
        return classUnit;
    }

    public void setClassUnit( ClassUnit classUnit ) {
        this.classUnit = classUnit;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList( List<Notification> notificationList ) {
        this.notificationList = notificationList;
    }
}

