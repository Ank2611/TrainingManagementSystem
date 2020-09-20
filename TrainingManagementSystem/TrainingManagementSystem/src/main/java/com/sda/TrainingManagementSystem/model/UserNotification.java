package com.sda.TrainingManagementSystem.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="readNotification_userNotification",
    joinColumns = @JoinColumn(name = "userNotification_id"),
    inverseJoinColumns = @JoinColumn(name="Notification_id"))
    private List<Notification> readNotificationList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="unreadNotification_userNotification",
            joinColumns = @JoinColumn(name = "userNotification_id"),
            inverseJoinColumns = @JoinColumn(name="Notification_id"))
    private List<Notification> unreadNotificationList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public List<Notification> getReadNotificationList() {
        return readNotificationList;
    }

    public void setReadNotificationList( List<Notification> readNotificationList ) {
        this.readNotificationList = readNotificationList;
    }

    public List<Notification> getUnreadNotificationList() {
        return unreadNotificationList;
    }

    public void setUnreadNotificationList( List<Notification> unreadNotificationList ) {
        this.unreadNotificationList = unreadNotificationList;
    }

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }
}
