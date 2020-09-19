package com.sda.TrainingManagementSystem.model;


import javax.persistence.*;

@Entity
public class UserNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
