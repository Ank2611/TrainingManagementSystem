package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.UserDto;
import java.util.List;

public interface UserService {
    UserDto getUserDto( Long id );

    List<UserDto> getAll();

    void addUser( UserDto userDto );

    void updateUser( UserDto userDto );

    void deleteUser(Long id);
}