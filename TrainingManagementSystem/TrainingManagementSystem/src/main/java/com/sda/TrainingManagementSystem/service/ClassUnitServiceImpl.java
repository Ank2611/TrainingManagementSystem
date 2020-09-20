package com.sda.TrainingManagementSystem.service;


import com.sda.TrainingManagementSystem.dto.ClassUnitDto;
import com.sda.TrainingManagementSystem.dto.ClassesDto;
import com.sda.TrainingManagementSystem.model.ClassUnit;
import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.repository.ClassUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassUnitServiceImpl implements ClassUnitService {

    @Autowired
    ClassUnitRepository classUnitRepository;

    @Override
    public ClassUnitDto getClassUnitDtoById( Long id ) {
        Optional<ClassUnit> classUnit = classUnitRepository.findById(id);
        if (classUnit.isPresent()) {
            ClassUnit classUnit1 = classUnit.get();
            ClassUnitDto classUnitDto = new ClassUnitDto();
            classUnitDto.setId(classUnit1.getId());
            classUnitDto.setName(classUnit1.getName());

            List<Classes> classes = classUnit1.getClassesList();
            List<ClassesDto> classesDtoList = new ArrayList<>();
            for (Classes classes1 : classes) {
                ClassesDto classesDto = new ClassesDto();
                classesDto.setId(classes1.getId());
                classesDto.setDate(classes1.getDate());
                classesDto.setSubject(classes1.getSubject());
                classesDtoList.add(classesDto);
            }

            classUnitDto.setClassesDtoList(classesDtoList);
        }
        return null;
    }

    @Override
    public List<ClassUnitDto> getAll() {
        List<ClassUnit> classUnitList = classUnitRepository.findAll();
        List<ClassUnitDto> classUnitDtoList = new ArrayList<>();
        for (ClassUnit classUnit: classUnitList) {
            ClassUnitDto classUnitDto = new ClassUnitDto();
            classUnitDto.setId(classUnit.getId());
            classUnitDto.setName(classUnit.getName());
            classUnitDtoList.add(classUnitDto);
        }
        return classUnitDtoList;
    }

    @Override
    public void addClassUnit( ClassUnitDto classUnitDto ) {
        ClassUnit newClassUnit = new ClassUnit();
        newClassUnit.setName(classUnitDto.getName());
        classUnitRepository.save(newClassUnit);
    }

    @Override
    public void updateClassUnit( ClassUnitDto classUnitDto ) {
        ClassUnit updClassUnit = new ClassUnit();
        updClassUnit.setName(classUnitDto.getName());
        classUnitRepository.saveAndFlush(updClassUnit);
    }

    @Override
    public void deleteClassUnit( Long id ) {
        classUnitRepository.deleteById(id);
    }
}
