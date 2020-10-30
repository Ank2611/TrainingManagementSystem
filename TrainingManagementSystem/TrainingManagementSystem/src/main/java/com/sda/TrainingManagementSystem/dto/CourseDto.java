package com.sda.TrainingManagementSystem.dto;


import java.util.ArrayList;
import java.util.List;

public class CourseDto {
    private Long id;
    private String name;
    private List<ClassUnitDto> classUnitDtoList = new ArrayList<>();
    private List<ParticipantRegistrationDto> participantRegistrationDtos = new ArrayList<>();

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

    public List<ClassUnitDto> getClassUnitDtoList() {
        return classUnitDtoList;
    }

    public void setClassUnitDtoList( List<ClassUnitDto> classUnitDtoList ) {
        this.classUnitDtoList = classUnitDtoList;
    }

    public List<ParticipantRegistrationDto> getParticipantRegistrationDtos() {
        return participantRegistrationDtos;
    }

    public void setParticipantRegistrationDtos( List<ParticipantRegistrationDto> participantRegistrationDtos ) {
        this.participantRegistrationDtos = participantRegistrationDtos;
    }
}
