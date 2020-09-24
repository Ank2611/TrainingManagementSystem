package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.ClassUnitDto;

import java.util.List;

public interface ClassUnitService {
    ClassUnitDto getClassUnitById( Long id );
    List<ClassUnitDto> getAll();
    void addClassUnit( ClassUnitDto classUnitDto );
    void updateClassUnit( ClassUnitDto classUnitDto );
    void deleteClassUnit( Long id );
}
