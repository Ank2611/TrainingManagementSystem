package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.CourseDto;
import com.sda.TrainingManagementSystem.dto.ParticipantRegistrationDto;
import com.sda.TrainingManagementSystem.dto.UserDto;
import com.sda.TrainingManagementSystem.model.Course;
import com.sda.TrainingManagementSystem.model.ParticipantRegistration;
import com.sda.TrainingManagementSystem.model.User;
import com.sda.TrainingManagementSystem.repository.CourseRepository;
import com.sda.TrainingManagementSystem.repository.ParticipantRegistrationRepository;
import com.sda.TrainingManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ParticipantRegistrationServiceImpl implements ParticipantRegistrationService {

    @Autowired
    private ParticipantRegistrationRepository repository;

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ParticipantRegistrationDto getParticipantDto( Long id ) {
        Optional<ParticipantRegistration> participantRegistration = repository.findById(id);
        ParticipantRegistrationDto participantRegistrationDto = new ParticipantRegistrationDto();
        if (participantRegistration.isPresent()) {
            ParticipantRegistration participantFound = participantRegistration.get();
            participantRegistrationDto.setId(participantFound.getId());
            participantRegistrationDto.setDate(participantFound.getDate());
            participantRegistrationDto.setAccepted(participantFound.isAccepted());

            CourseDto courseDto = new CourseDto();
            Course course = participantFound.getCourse();
            courseDto.setId(course.getId());
            courseDto.setName(course.getName());
            participantRegistrationDto.setCourseDto(courseDto);


            UserDto userDto = new UserDto();
            User user = participantFound.getUser();
            userDto.setId(user.getId());
            userDto.setUserName(user.getUserName());
            userDto.setFirstName(user.getFirstName());
            userDto.setType(user.getType().name());
            userDto.setStatus(user.isStatus());
            participantRegistrationDto.setUserDto(userDto);
            return participantRegistrationDto;

        }
        return null;
    }

    @Override
    public List<ParticipantRegistrationDto> getAll() {
        List<ParticipantRegistrationDto> participantDtoList = new ArrayList<>();
        List<ParticipantRegistration> participantList = repository.findAll();

        for (ParticipantRegistration participant : participantList) {
            ParticipantRegistrationDto participantRegistrationDto = new ParticipantRegistrationDto();
            participantRegistrationDto.setId(participant.getId());
            participantRegistrationDto.setDate(participant.getDate());
            participantRegistrationDto.setAccepted(participant.isAccepted());

            CourseDto courseDto = new CourseDto();
            Course course = participant.getCourse();
            courseDto.setId(course.getId());
            courseDto.setName(course.getName());
            participantRegistrationDto.setCourseDto(courseDto);

            UserDto userDto = new UserDto();
            User user = participant.getUser();
            userDto.setId(user.getId());
            userDto.setUserName(user.getUserName());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setType(user.getType().name());
            userDto.setStatus(user.isStatus());
            participantRegistrationDto.setUserDto(userDto);
            participantDtoList.add(participantRegistrationDto);

        }
        return participantDtoList;
    }

    @Override
    public void addParticipantRegistration( ParticipantRegistrationDto participantRegistrationDto ) {

        ParticipantRegistration newParticipantRegistration = new ParticipantRegistration();
        CourseDto courseDto = participantRegistrationDto.getCourseDto();
        Optional<Course> foundCourse = courseRepository.findById(courseDto.getId());
        UserDto userDto = participantRegistrationDto.getUserDto();
        Optional<User> foundUser = userRepository.findById(userDto.getId());

        if(foundCourse.isPresent() && foundUser.isPresent()){
            newParticipantRegistration.setCourse(foundCourse.get());
            newParticipantRegistration.setUser(foundUser.get());
        }
            newParticipantRegistration.setDate(new Date());
            newParticipantRegistration.setAccepted(participantRegistrationDto.isAccepted());

            repository.save(newParticipantRegistration);

    }

    @Override
    public void updateParticipant( ParticipantRegistrationDto participantRegistrationDto ) {
        Optional<ParticipantRegistration> participantRegistration = repository.findById(participantRegistrationDto.getId());
        if (participantRegistration.isPresent()) {
            ParticipantRegistration updParticipantRegistration = participantRegistration.get();

            CourseDto courseDto = participantRegistrationDto.getCourseDto();
            Optional<Course> foundCourse = courseRepository.findById(courseDto.getId());
            if (foundCourse.isPresent()) {
                updParticipantRegistration.setCourse(foundCourse.get());
            }

            UserDto userDto = participantRegistrationDto.getUserDto();
            Optional<User> foundUser = userRepository.findById(userDto.getId());
            if (foundUser.isPresent()) {
                updParticipantRegistration.setUser(foundUser.get());
            }

            updParticipantRegistration.setAccepted(participantRegistrationDto.isAccepted());

            repository.saveAndFlush(updParticipantRegistration);
        }
    }

    @Override
    public void deleteParticipant( Long id ) {
        repository.deleteById(id);
    }
}
