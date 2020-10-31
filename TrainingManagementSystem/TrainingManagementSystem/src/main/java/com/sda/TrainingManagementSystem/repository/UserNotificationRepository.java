package com.sda.TrainingManagementSystem.repository;

import com.sda.TrainingManagementSystem.model.User;
import com.sda.TrainingManagementSystem.model.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
}
