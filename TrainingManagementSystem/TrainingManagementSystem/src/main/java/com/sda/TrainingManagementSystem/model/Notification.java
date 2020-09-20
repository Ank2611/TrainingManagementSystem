package com.sda.TrainingManagementSystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String contents;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="classes_notification",
            joinColumns = @JoinColumn(name="notification_id"),
            inverseJoinColumns = @JoinColumn(name = "classes_id"))
    private List<Classes> classes = new ArrayList<>();

    @ManyToMany(mappedBy = "readNotification", cascade = CascadeType.ALL)
    private List<UserNotification> userNotificationList = new ArrayList<>();

    @ManyToMany(mappedBy = "unreadNotification", cascade = CascadeType.ALL)
    private List<UserNotification> userNotificationList1 = new ArrayList<>();

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

    public String getContents() {
        return contents;
    }

    public void setContents( String contents ) {
        this.contents = contents;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses( List<Classes> classes ) {
        this.classes = classes;
    }

    public List<UserNotification> getUserNotificationList() {
        return userNotificationList;
    }

    public void setUserNotificationList( List<UserNotification> userNotificationList ) {
        this.userNotificationList = userNotificationList;
    }

    public List<UserNotification> getUserNotificationList1() {
        return userNotificationList1;
    }

    public void setUserNotificationList1( List<UserNotification> userNotificationList1 ) {
        this.userNotificationList1 = userNotificationList1;
    }

}
