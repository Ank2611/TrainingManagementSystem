package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.NotificationByClassesDto;
import com.sda.TrainingManagementSystem.dto.NotificationDto;
import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.model.Notification;
import com.sda.TrainingManagementSystem.model.User;
import com.sda.TrainingManagementSystem.model.UserNotification;
import com.sda.TrainingManagementSystem.repository.ClassesRepository;
import com.sda.TrainingManagementSystem.repository.NotificationRepository;
import com.sda.TrainingManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private ClassesRepository classesRepository;
    @Autowired
    private UserRepository userRepository;

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
        Optional<Notification> foundNotification = notificationRepository.findById(notificationDto.getId());
        if (foundNotification.isPresent()) {
            Notification updNotification = foundNotification.get();
            updNotification.setSubject(notificationDto.getSubject());
            updNotification.setContents(notificationDto.getContents());
            notificationRepository.saveAndFlush(updNotification);
        }

    }

    @Override
    public void deleteNotification( Long id ) {
        notificationRepository.deleteById(id);
    }

    @Override
    public void addNewNotificationToClasses( NotificationDto notificationDto, Long idClasses ) {
        Notification newNotification = new Notification();
        newNotification.setContents(notificationDto.getContents());
        newNotification.setSubject(notificationDto.getSubject());
        notificationRepository.save(newNotification);

        Optional<Classes> foundclasses = classesRepository.findById(idClasses);
        if (foundclasses.isPresent()) {
            Classes classes = foundclasses.get();
            newNotification.getClasses().add(classes);
            classesRepository.save(classes);
        }
    }

    @Override
    public List<NotificationByClassesDto> getAllNotificationByClasses( Long idClasses ) {
        return notificationRepository.getAllNotificationByClasses(idClasses);
    }

    @Override
    public List<NotificationDto> getAllReadNotification( Long id ) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserNotification userNotification = user.getUserNotification();
            List<Notification> readNotification = userNotification.getReadNotificationList();
            List<NotificationDto> readNotificationDtos = new ArrayList<>();
            for (Notification notification : readNotification) {
                NotificationDto readNotificationDto = new NotificationDto();
                readNotificationDto.setId(notification.getId());
                readNotificationDto.setSubject(notification.getSubject());
                readNotificationDto.setContents(notification.getContents());
                readNotificationDtos.add(readNotificationDto);
            }
            return readNotificationDtos;
        }
        return null;
    }

    @Override
    public List<NotificationDto> getAllUnreadNotification( Long id ) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserNotification userNotification = user.getUserNotification();
            List<Notification> unreadNotification = userNotification.getUnreadNotificationList();
            List<NotificationDto> unreadNotificationDtos = new ArrayList<>();
            for (Notification notification : unreadNotification) {
                NotificationDto unreadNotificationDto = new NotificationDto();
                unreadNotificationDto.setId(notification.getId());
                unreadNotificationDto.setSubject(notification.getSubject());
                unreadNotificationDto.setContents(notification.getContents());
                unreadNotificationDtos.add(unreadNotificationDto);
            }
            return unreadNotificationDtos;
        }
        return null;
    }
}
