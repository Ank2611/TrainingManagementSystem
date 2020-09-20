package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.CourseDto;
import com.sda.TrainingManagementSystem.dto.ParticipantRegistrationDto;
import com.sda.TrainingManagementSystem.dto.UserDto;
import com.sda.TrainingManagementSystem.model.Course;
import com.sda.TrainingManagementSystem.model.ParticipantRegistration;
import com.sda.TrainingManagementSystem.model.Type;
import com.sda.TrainingManagementSystem.model.User;
import com.sda.TrainingManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto getUserDto( Long id ) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User userFounded = user.get();
            UserDto userDto = new UserDto();
            userDto.setId(userFounded.getId());
            userDto.setUserName(userFounded.getUserName());
            userDto.setPassword(userFounded.getPassword());
            userDto.setType(userFounded.getType().name());
            userDto.setFirstName(userFounded.getFirstName());
            userDto.setLastName(userFounded.getLastName());
            userDto.setActive(userFounded.isActive());

            return userDto;
        }
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto();
            ParticipantRegistrationDto participantRegistrationDto = new ParticipantRegistrationDto();
            ParticipantRegistration participantRegistration = user.getParticipantRegistration();
            CourseDto courseDto = new CourseDto();
            Course course = participantRegistration.getCourse();

            userDto.setId(user.getId());
            userDto.setUserName(user.getUserName());
            userDto.setPassword(user.getPassword());
            userDto.setType(user.getType().name());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setActive(user.isActive());

            courseDto.setId(course.getId());
            courseDto.setName(course.getName());

            participantRegistrationDto.setId(participantRegistration.getId());
            participantRegistrationDto.setCourseDto(courseDto);
            participantRegistrationDto.setDate(participantRegistration.getDate());
            userDto.setParticipantRegistrationDto(participantRegistrationDto);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public void addUser( UserDto userDto ) {
        User newUser = new User();
        newUser.setUserName(userDto.getUserName());
        newUser.setPassword(userDto.getPassword());
        newUser.setType(Type.valueOf(userDto.getType()));
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setActive(userDto.isActive());
        userRepository.save(newUser);
    }

    @Override
    public void updateUser( UserDto userDto ) {

        Optional<User> foundUser = userRepository.findById(userDto.getId());
        if (foundUser.isPresent()) {
            User user = foundUser.get();
            user.setUserName(userDto.getUserName());
            user.setPassword(userDto.getPassword());
            user.setType(Type.valueOf(userDto.getType()));
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setActive(userDto.isActive());
            userRepository.saveAndFlush(user);
        }
    }

    @Override
    public void deleteUser( Long id ) {
        userRepository.deleteById(id);
    }
}
