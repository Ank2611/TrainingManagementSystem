package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto getCourseDtoById(Long id);
    List<CourseDto> getAll();
    void addCourse(CourseDto courseDto);
    void updateCourse(CourseDto courseDto);
    void deleteCourse(Long id);
}
