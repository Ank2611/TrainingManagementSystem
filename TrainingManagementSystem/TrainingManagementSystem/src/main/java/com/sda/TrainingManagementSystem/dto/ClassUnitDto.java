package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.model.Course;

import java.util.ArrayList;
import java.util.List;

public class ClassUnitDto {
    private Long id;
    private String name;
    private List<Course> courses = new ArrayList<>();
    private List<Classes> classesList = new ArrayList<>();

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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses( List<Course> courses ) {
        this.courses = courses;
    }

    public List<Classes> getClassesList() {
        return classesList;
    }

    public void setClassesList( List<Classes> classesList ) {
        this.classesList = classesList;
    }
}
