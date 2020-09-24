package com.sda.TrainingManagementSystem.controller;

import com.sda.TrainingManagementSystem.dto.UserNotificationDto;
import com.sda.TrainingManagementSystem.model.UserNotification;
import com.sda.TrainingManagementSystem.service.UserNotificationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="usernotification")
public class UserNotificationController {

    @Autowired
    private UserNotificationService userNotificationService;

    @GetMapping("/getUserNotifications")
    public ResponseEntity<List<UserNotificationDto>> getAll(){
        List<UserNotificationDto> userNotificationDtoList = userNotificationService.getAll();
        return new ResponseEntity(userNotificationDtoList, HttpStatus.OK);
    }

    @GetMapping("/getUserNotification/{id}")
    public ResponseEntity<UserNotificationDto> findById(@PathVariable("id") Long id){
        UserNotificationDto userNotificationDto = userNotificationService.getUserNotificationById(id);
        return new ResponseEntity(userNotificationDto, HttpStatus.OK);
    }

    @PostMapping("/addUserNotification")
    public ResponseEntity addUserNotification(@RequestBody UserNotificationDto userNotificationDto){
        userNotificationService.addUserNotification(userNotificationDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateUserNotification")
    public ResponseEntity updateUserNotification(@RequestBody UserNotificationDto userNotificationDto){
        userNotificationService.updateUserNotification(userNotificationDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        userNotificationService.deleteUserNotification(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
