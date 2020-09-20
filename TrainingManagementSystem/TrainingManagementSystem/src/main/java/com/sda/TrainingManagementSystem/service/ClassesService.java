package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.ClassesDto;


import java.util.List;

public interface ClassesService {
    ClassesDto getClassesDtoById( Long id );
    List<ClassesDto> getAll();
    void addClasses( ClassesDto classesDto );
    void updateClasses( ClassesDto classesDto );
    void deleteClasses( Long id );
}
