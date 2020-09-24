package com.sda.TrainingManagementSystem.dto;


import java.util.ArrayList;
import java.util.List;

public class CourseDto {
    private long id;
    private String name;
    private List<ClassUnitDto> classUnitDtoList = new ArrayList<>();
    private ParticipantRegistrationDto participantRegistrationDto;

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

    public List<ClassUnitDto> getClassUnitDtoList() {
        return classUnitDtoList;
    }

    public void setClassUnitDtoList( List<ClassUnitDto> classUnitDtoList ) {
        this.classUnitDtoList = classUnitDtoList;
    }

    public ParticipantRegistrationDto getParticipantRegistrationDto() {
        return participantRegistrationDto;
    }

    public void setParticipantRegistrationDto( ParticipantRegistrationDto participantRegistrationDto ) {
        this.participantRegistrationDto = participantRegistrationDto;
    }
}
