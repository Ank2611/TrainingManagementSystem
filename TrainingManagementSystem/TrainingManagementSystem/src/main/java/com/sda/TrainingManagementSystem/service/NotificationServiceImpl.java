package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.NotificationDto;
import com.sda.TrainingManagementSystem.model.Notification;
import com.sda.TrainingManagementSystem.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public NotificationDto getNotificationById( Long id ) {
        Optional<Notification> foundNotification = notificationRepository.findById(id);
        NotificationDto notificationDto = new NotificationDto();
        if (foundNotification.isPresent()) {
            Notification notification = foundNotification.get();
            notificationDto.setId(notification.getId());
            notificationDto.setSubject(notification.getSubject());
            notificationDto.setContents(notification.getContents());
            return notificationDto;
        }
        return null;
    }

    @Override
    public List<NotificationDto> getAll() {
        List<Notification> notificationList = notificationRepository.findAll();
        List<NotificationDto> notificationDtoList = new ArrayList<>();
        for (Notification notification : notificationList) {
            NotificationDto notificationDto = new NotificationDto();
            notificationDto.setId(notification.getId());
            notificationDto.setSubject(notification.getSubject());
            notificationDto.setContents(notification.getContents());
            notificationDtoList.add(notificationDto);
        }
        return notificationDtoList;
    }

    @Override
    public void addNotification( NotificationDto notificationDto ) {
        Notification newNotification = new Notification();
        newNotification.setSubject(notificationDto.getSubject());
        newNotification.setContents(notificationDto.getContents());
        notificationRepository.save(newNotification);
    }

    @Override
    public void updateNotification( NotificationDto notificationDto ) {
        Notification updNotification = new Notification();
        updNotification.setSubject(notificationDto.getSubject());
        updNotification.setContents(notificationDto.getContents());
        notificationRepository.saveAndFlush(updNotification);
    }

    @Override
    public void deleteNotification( Long id ) {
        notificationRepository.deleteById(id);
    }
}
