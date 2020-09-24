package com.sda.TrainingManagementSystem.controller;


import com.sda.TrainingManagementSystem.dto.UserDto;
import com.sda.TrainingManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> userDtoList = userService.getAll();
        return new ResponseEntity(userDtoList, HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id){
        UserDto userDto = userService.getUserDto(id);
        return new ResponseEntity(userDto, HttpStatus.OK);
    }

//    @GetMapping("/getUser/{type}")
//    public ResponseEntity<UserDto> findByType(@PathVariable("type") String type){
//        List<UserDto> userDtoList = userService.findByType(type);
//        return new ResponseEntity(userDtoList, HttpStatus.OK);
//    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
