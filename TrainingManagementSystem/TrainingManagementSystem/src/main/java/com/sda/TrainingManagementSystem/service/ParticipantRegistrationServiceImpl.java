package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.CourseDto;
import com.sda.TrainingManagementSystem.dto.ParticipantRegistrationDto;
import com.sda.TrainingManagementSystem.dto.UserDto;
import com.sda.TrainingManagementSystem.model.Course;
import com.sda.TrainingManagementSystem.model.ParticipantRegistration;
import com.sda.TrainingManagementSystem.model.User;
import com.sda.TrainingManagementSystem.repository.ParticipantRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ParticipantRegistrationServiceImpl implements ParticipantRegistrationService {

    @Autowired
    ParticipantRegistrationRepository repository;

    @Override
    public ParticipantRegistrationDto getParticipantDto( Long id ) {
        Optional<ParticipantRegistration> participantRegistration = repository.findById(id);
        ParticipantRegistrationDto participantRegistrationDto = new ParticipantRegistrationDto();
        if (participantRegistration.isPresent()) {
            ParticipantRegistration participantFound = participantRegistration.get();
            participantRegistrationDto.setId(participantFound.getId());
            participantRegistrationDto.setDate(participantFound.getDate());

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
            userDto.setActive(user.isActive());
            participantRegistrationDto.setUserDto(userDto);

        }
        return participantRegistrationDto;
    }

    @Override
    public List<ParticipantRegistrationDto> getAll() {
        List<ParticipantRegistrationDto> participantDtoList = new ArrayList<>();
        List<ParticipantRegistration> participantList = repository.findAll();

        for (ParticipantRegistration participant : participantList) {
            ParticipantRegistrationDto participantRegistrationDto = new ParticipantRegistrationDto();
            participantRegistrationDto.setId(participant.getId());
            participantRegistrationDto.setDate(participant.getDate());

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
            userDto.setType(user.getType().name());
            userDto.setActive(user.isActive());
            participantRegistrationDto.setUserDto(userDto);

            participantDtoList.add(participantRegistrationDto);

        }
        return null;
    }

    @Override
    public void addParticipantRegistration( ParticipantRegistrationDto participantRegistrationDto ) {
        Optional<ParticipantRegistration> foundParticipantRegistration = repository.findById(participantRegistrationDto.getId());
        if (foundParticipantRegistration.isPresent()) {
            ParticipantRegistration newParticipantRegistration = new ParticipantRegistration();
            newParticipantRegistration.setDate(new Date());

            CourseDto courseDto = participantRegistrationDto.getCourseDto();
            Course course = new Course();
            course.setId(courseDto.getId());
            course.setName(courseDto.getName());
            newParticipantRegistration.setCourse(course);

            UserDto userDto = participantRegistrationDto.getUserDto();
            User user = new User();
            user.setId(userDto.getId());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setUserName(userDto.getUserName());
            newParticipantRegistration.setUser(user);

            repository.save(newParticipantRegistration);
        }
    }

    @Override
    public void updateParticipant( ParticipantRegistrationDto participantRegistrationDto ) {
        Optional<ParticipantRegistration> participantRegistration = repository.findById(participantRegistrationDto.getId());
        if (participantRegistration.isPresent()) {
            ParticipantRegistration updParticipantRegistration = new ParticipantRegistration();
//            updParticipantRegistration.setDate(participantRegistrationDto.getDate());

            CourseDto courseDto = participantRegistrationDto.getCourseDto();
            Course course = new Course();
            course.setName(courseDto.getName());
            updParticipantRegistration.setCourse(course);

            UserDto userDto = participantRegistrationDto.getUserDto();
            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setUserName(userDto.getUserName());
            updParticipantRegistration.setUser(user);

            repository.saveAndFlush(updParticipantRegistration);
        }

        }

    @Override
    public void deleteParticipant( Long id ) {
        repository.deleteById(id);
    }
}
