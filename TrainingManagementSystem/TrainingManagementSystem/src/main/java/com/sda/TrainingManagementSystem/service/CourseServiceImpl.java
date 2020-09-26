package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.CourseDto;
import com.sda.TrainingManagementSystem.model.Course;
import com.sda.TrainingManagementSystem.model.ParticipantRegistration;
import com.sda.TrainingManagementSystem.model.User;
import com.sda.TrainingManagementSystem.repository.CourseRepository;
import com.sda.TrainingManagementSystem.repository.ParticipantRegistrationRepository;
import com.sda.TrainingManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ParticipantRegistrationRepository participantRegistrationRepository;

    @Override
    public CourseDto getCourseDtoById( Long id ) {
        Optional<Course> courseFound = courseRepository.findById(id);
        if (courseFound.isPresent()) {
            Course course = courseFound.get();
            CourseDto courseDto = new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setName(course.getName());
            return courseDto;
        }
        return null;
    }

    @Override
    public List<CourseDto> getAll() {
        List<Course> courseList = courseRepository.findAll();
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Course course : courseList) {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setName(course.getName());
            courseDtoList.add(courseDto);
        }
        return courseDtoList;
    }

    @Override
    public void addCourse( CourseDto courseDto ) {
        Course newCourse = new Course();
        newCourse.setName(courseDto.getName());
        courseRepository.save(newCourse);
    }

    @Override
    public void updateCourse( CourseDto courseDto ) {
        Optional<Course> foundCourse = courseRepository.findById(courseDto.getId());
        if(foundCourse.isPresent()) {
            Course updCourse = foundCourse.get();
            updCourse.setName(courseDto.getName());
            courseRepository.saveAndFlush(updCourse);
        }
    }

    @Override
    public void deleteCourse( Long id ) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDto> findAllCoursesByUser( Long id ) {
        List<Course> coursesByUser = courseRepository.findAllCoursesByUser(id);
        List<CourseDto> courseDtoList = new ArrayList<>();
        for(Course course : coursesByUser){
            CourseDto courseDto = new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setName(course.getName());
            courseDtoList.add(courseDto);
        }
        return courseDtoList;
    }
}
