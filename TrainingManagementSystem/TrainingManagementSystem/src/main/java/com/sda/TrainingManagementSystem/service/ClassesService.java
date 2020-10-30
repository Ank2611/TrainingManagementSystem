package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.ClassesByUserDto;
import com.sda.TrainingManagementSystem.dto.ClassesDto;


import java.util.Date;
import java.util.List;

public interface ClassesService {
    ClassesDto getClassesDtoById( Long id );
    List<ClassesDto> getAll();
    void addClasses( ClassesDto classesDto );
    void updateClasses( ClassesDto classesDto );
    void deleteClasses( Long id );
    void addNewClassesInClassUnit(ClassesDto classesDto, Long idClassUnit);
    void linkClassesInClassUnit(Long idClassesDto, Long idClassUnit);
    List<ClassesDto> getAllByClassUnitId(Long id);
    List<ClassesByUserDto> getAllClassesByUser(Long idUser, Date date);
}
