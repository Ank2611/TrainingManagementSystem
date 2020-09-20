package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.ClassUnitDto;
import com.sda.TrainingManagementSystem.dto.ClassesDto;
import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    ClassesRepository classesRepository;


    @Override
    public ClassesDto getClassesDtoById( Long id ) {
        Optional<Classes> classes = classesRepository.findById(id);
        if (classes.isPresent()) {
            ClassesDto classesDto = new ClassesDto();
            Classes classes1 = classes.get();
            classesDto.setId(classes1.getId());
            classesDto.setDate(classes1.getDate());
            classesDto.setSubject(classes1.getSubject());
            return classesDto;
        }
        return null;
    }

    @Override
    public List<ClassesDto> getAll() {
        List<Classes> classesList = classesRepository.findAll();
        List<ClassesDto> classesDtoList = new ArrayList<>();
        for (Classes classses : classesList) {
            ClassesDto classesDto = new ClassesDto();
            classesDto.setId(classses.getId());
            classesDto.setDate(classses.getDate());
            classesDto.setSubject(classses.getSubject());
            classesDtoList.add(classesDto);
        }
        return classesDtoList;
    }

    @Override
    public void addClasses( ClassesDto classesDto ) {
        Classes newClassses = new Classes();
        newClassses.setDate(classesDto.getDate());
        newClassses.setSubject(classesDto.getSubject());
        classesRepository.save(newClassses);
    }

    @Override
    public void updateClasses( ClassesDto classesDto ) {
        Classes updClasses = new Classes();
        updClasses.setDate(classesDto.getDate());
        updClasses.setSubject(classesDto.getSubject());
        classesRepository.saveAndFlush(updClasses);
    }

    @Override
    public void deleteClasses( Long id ) {
        classesRepository.deleteById(id);
    }
}
