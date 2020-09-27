package com.sda.TrainingManagementSystem.controller;


import com.sda.TrainingManagementSystem.dto.CourseDto;
import com.sda.TrainingManagementSystem.dto.NotificationDto;
import com.sda.TrainingManagementSystem.model.Notification;
import com.sda.TrainingManagementSystem.service.NotificationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/getNotifications")
    public ResponseEntity<List<NotificationDto>> getAll(){
        List<NotificationDto> notificationDtoList = notificationService.getAll();
        return new ResponseEntity(notificationDtoList, HttpStatus.OK);
    }

    @GetMapping("/getNotification/{id}")
    public ResponseEntity<NotificationDto> findById(@PathVariable("id") Long id){
        NotificationDto notificationDto = notificationService.getNotificationById(id);
        return new ResponseEntity(notificationDto, HttpStatus.OK);
    }


    @PostMapping("/addNotification")
    public ResponseEntity addNotification(@RequestBody NotificationDto notificationDto ){
        notificationService.updateNotification(notificationDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/addNewNotificationToClasses/{id}")
    public ResponseEntity addNewNotificationToClasses(@RequestBody NotificationDto notificationDto, @PathVariable("id") Long id ){
        notificationService.addNewNotificationToClasses(notificationDto, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateCourse")
    public ResponseEntity updateNotification(@RequestBody NotificationDto notificationDto){
        notificationService.updateNotification(notificationDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity deleteNotification(@PathVariable("id") Long id){
        notificationService.deleteNotification(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
