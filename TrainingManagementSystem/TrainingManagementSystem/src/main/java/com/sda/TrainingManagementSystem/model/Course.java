package com.sda.TrainingManagementSystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "course_classUnit",
            joinColumns = {@JoinColumn(name = "courseId", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "classUnitId", nullable = false, updatable = false)})
    private List<ClassUnit> classUnitList = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<ParticipantRegistration> participantRegistrationList;

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

    public List<ClassUnit> getClassUnitList() {
        return classUnitList;
    }

    public void setClassUnitList( List<ClassUnit> classUnitList ) {
        this.classUnitList = classUnitList;
    }

    public List<ParticipantRegistration> getParticipantRegistrationList() {
        return participantRegistrationList;
    }

    public void setParticipantRegistrationList( List<ParticipantRegistration> participantRegistrationList ) {
        this.participantRegistrationList = participantRegistrationList;
    }
}

