package com.sda.TrainingManagementSystem.repository;

import com.sda.TrainingManagementSystem.dto.NotificationByClassesDto;
import com.sda.TrainingManagementSystem.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("select new com.sda.TrainingManagementSystem.dto.NotificationByClassesDto(cu.name as classUnit_name, cls.subject as classes_subject, cls.date as classes_date, n.subject as notification_subject, n.contents as notification_contents) from Notification n\n"+
    "join n.classes cls\n"+
    "join cls.classUnit cu\n"+
    "where cls.id= :id")
    List<NotificationByClassesDto> getAllNotificationByClasses(@Param("id") Long id );



}
