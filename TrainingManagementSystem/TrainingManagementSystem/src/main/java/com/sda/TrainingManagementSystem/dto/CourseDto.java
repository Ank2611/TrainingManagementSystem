package com.sda.TrainingManagementSystem.dto;

import com.sda.TrainingManagementSystem.model.ClassUnit;
import com.sda.TrainingManagementSystem.model.ParticipantRegistration;

import java.util.ArrayList;
import java.util.List;

public class CourseDto {
    private long id;
    private String name;
    private List<ClassUnit> classUnitList = new ArrayList<>();
    private ParticipantRegistration participantRegistration;

    public long getId() {
        return id;
    }

    public void setId( long id ) {
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

    public ParticipantRegistration getParticipantRegistration() {
        return participantRegistration;
    }

    public void setParticipantRegistration( ParticipantRegistration participantRegistration ) {
        this.participantRegistration = participantRegistration;
    }
}
