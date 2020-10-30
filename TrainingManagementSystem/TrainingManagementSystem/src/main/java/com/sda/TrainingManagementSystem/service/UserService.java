package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.CourseDto;
import com.sda.TrainingManagementSystem.dto.UserDto;
import com.sda.TrainingManagementSystem.model.User;

import java.util.List;

public interface UserService {
    UserDto getUserDto( Long id );

    List<UserDto> getAll();

    void addUser( UserDto userDto );

    void updateUser( UserDto userDto );

    void deleteUser( Long id );

    List<UserDto> findByType( String type );


}
