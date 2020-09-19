package com.sda.TrainingManagementSystem.repository;

import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
