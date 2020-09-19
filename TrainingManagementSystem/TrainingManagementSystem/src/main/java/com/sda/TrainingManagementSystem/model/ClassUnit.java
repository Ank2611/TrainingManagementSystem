package com.sda.TrainingManagementSystem.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ClassUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="classUnitList")
    private List<Course> courses;

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="classes")
    private List<Classes> classes;

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

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses( List<Classes> classes ) {
        this.classes = classes;
    }

}
