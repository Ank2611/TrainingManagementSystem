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

   @OneToMany
   @JoinColumn(name="classUnit_id")
   private List<User> usersList;

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

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList( List<User> usersList ) {
        this.usersList = usersList;
    }
}
