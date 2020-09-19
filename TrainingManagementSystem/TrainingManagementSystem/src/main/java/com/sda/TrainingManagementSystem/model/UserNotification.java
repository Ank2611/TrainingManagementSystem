package com.sda.TrainingManagementSystem.model;


import javax.persistence.*;

@Entity
public class UserNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notification readNotification;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notification unreadNotification;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
