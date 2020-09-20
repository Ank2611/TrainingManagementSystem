package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.model.Course;

import java.util.ArrayList;
import java.util.List;

public class ClassUnitDto {
    private Long id;
    private String name;
    private List<CourseDto> coursesDto = new ArrayList<>();
    private List<ClassesDto> classesDtoList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public List<CourseDto> getCoursesDto() {
        return coursesDto;
    }

    public void setCoursesDto( List<CourseDto> coursesDto ) {
        this.coursesDto = coursesDto;
    }

    public List<ClassesDto> getClassesDtoList() {
        return classesDtoList;
    }

    public void setClassesDtoList( List<ClassesDto> classesDtoList ) {
        this.classesDtoList = classesDtoList;
    }
}
