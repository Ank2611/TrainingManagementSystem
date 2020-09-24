package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.NotificationDto;
import com.sda.TrainingManagementSystem.dto.UserDto;
import com.sda.TrainingManagementSystem.dto.UserNotificationDto;
import com.sda.TrainingManagementSystem.model.Notification;
import com.sda.TrainingManagementSystem.model.Type;
import com.sda.TrainingManagementSystem.model.User;
import com.sda.TrainingManagementSystem.model.UserNotification;
import com.sda.TrainingManagementSystem.repository.UserNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserNotificationServiceImpl implements UserNotificationService {

    @Autowired
    private UserNotificationRepository userNotificationRepository;

    @Override
    public UserNotificationDto getUserNotificationById( Long id ) {
        Optional<UserNotification> foundUser = userNotificationRepository.findById(id);
        UserNotificationDto userNotificationDto = new UserNotificationDto();
        if (foundUser.isPresent()) {
            userNotificationDto.setId(foundUser.get().getId());
            return userNotificationDto;
        }
        return null;
    }

    @Override
    public List<UserNotificationDto> getAll() {
        List<UserNotification> userNotificationList = new ArrayList<>();
        List<UserNotificationDto> userNotificationDtoList = new ArrayList<>();

        for (UserNotification userNotification : userNotificationList) {
            UserNotificationDto userNotificationDto = new UserNotificationDto();
            userNotificationDto.setId(userNotification.getId());
            User user = userNotification.getUser();
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setType(user.getType().name());

            userNotificationDto.setUserDto(userDto);

            List<Notification> readNotificationList = userNotification.getReadNotificationList();
            List<NotificationDto> notificationDtoList = new ArrayList<>();
            for(Notification readNotification : readNotificationList){
                NotificationDto notificationDto = new NotificationDto();
                notificationDto.setId(readNotification.getId());
                notificationDto.setSubject(readNotification.getSubject());
                notificationDto.setContents(readNotification.getContents());
                notificationDtoList.add(notificationDto);
            }

            userNotificationDto.setReadNotificationDtoList(notificationDtoList);

            List<Notification> unreadNotificationList = userNotification.getUnreadNotificationList();
            List<NotificationDto> notificationDtoList1 = new ArrayList<>();
            for(Notification unreadNotification : unreadNotificationList){
                NotificationDto notificationDto = new NotificationDto();
                notificationDto.setId(unreadNotification.getId());
                notificationDto.setSubject(unreadNotification.getSubject());
                notificationDto.setContents(unreadNotification.getContents());
                notificationDtoList1.add(notificationDto);
            }

            userNotificationDto.setUnreadNotificationDtoList(notificationDtoList1);

            userNotificationDtoList.add(userNotificationDto);

        }
        return userNotificationDtoList;
    }

    @Override
    public void addUserNotification( UserNotificationDto userNotificationDto ) {
        UserNotification newUserNotification = new UserNotification();

        User user = new User();
        UserDto userDto = userNotificationDto.getUserDto();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setType(Type.valueOf(userDto.getType()));

        newUserNotification.setUser(user);
        userNotificationRepository.save(newUserNotification);
    }

    @Override
    public void updateUserNotification( UserNotificationDto userNotificationDto ) {
        Optional<UserNotification> foundUserNotification = userNotificationRepository.findById(userNotificationDto.getId());
        if (foundUserNotification.isPresent()) {
            UserNotification updUserNotification = foundUserNotification.get();
            User user = new User();
            UserDto userDto = userNotificationDto.getUserDto();
            user.setId(userDto.getId());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setType(Type.valueOf(userDto.getType()));

            updUserNotification.setUser(user);
            userNotificationRepository.saveAndFlush(updUserNotification);
        }
    }

    @Override
    public void deleteUserNotification( Long id ) {
        userNotificationRepository.deleteById(id);
    }
}
