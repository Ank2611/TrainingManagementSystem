package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.ClassUnitDto;
import com.sda.TrainingManagementSystem.dto.ClassesByUserDto;
import com.sda.TrainingManagementSystem.dto.ClassesDto;
import com.sda.TrainingManagementSystem.model.ClassUnit;
import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.repository.ClassUnitRepository;
import com.sda.TrainingManagementSystem.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesRepository classesRepository;
    @Autowired
    private ClassUnitRepository classUnitRepository;

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
    public void addNewClassesInClassUnit( ClassesDto classesDto, Long idClassUnit ) {
        Classes newClassses = new Classes();
        newClassses.setDate(classesDto.getDate());
        newClassses.setSubject(classesDto.getSubject());

        classesRepository.save(newClassses);

        Optional<ClassUnit> foundClassUnit = classUnitRepository.findById(idClassUnit);
        if (foundClassUnit.isPresent()) {
            ClassUnit classUnit = foundClassUnit.get();
            classUnit.getClassesList().add(newClassses);
            classUnitRepository.save(classUnit);
        }
    }

    @Override
    public void linkClassesInClassUnit( Long idClassUnit, Long idClasses ) {
        Optional<ClassUnit> foundClassUnit = classUnitRepository.findById(idClassUnit);
        if (foundClassUnit.isPresent()) {
            ClassUnit classUnit = foundClassUnit.get();
            Optional<Classes> foundClasses = classesRepository.findById(idClasses);
            if (foundClasses.isPresent()) {
                Classes classes = foundClasses.get();
                classes.setClassUnit(classUnit);
                classesRepository.save(classes);
            }
        }
    }

    @Override
    public List<ClassesDto> getAllByClassUnitId( Long id ) {

        Optional<ClassUnit> foundClassUnit = classUnitRepository.findById(id);
        if (foundClassUnit.isPresent()) {
            ClassUnit classUnit = foundClassUnit.get();
            List<Classes> classesList = classUnit.getClassesList();
            List<ClassesDto> classesDtoList = new ArrayList<>();
            for (Classes classes : classesList) {
                ClassesDto classesDto = new ClassesDto();
                classesDto.setId(classes.getId());
                classesDto.setDate(classes.getDate());
                classesDto.setSubject(classes.getSubject());
                classesDtoList.add(classesDto);
            }
            return classesDtoList;
        }
        return null;
    }

    @Override
    public void updateClasses( ClassesDto classesDto ) {
        Optional<Classes> foundClasses = classesRepository.findById(classesDto.getId());
        if (foundClasses.isPresent()) {
            Classes updClasses = foundClasses.get();
            updClasses.setDate(classesDto.getDate());
            updClasses.setSubject(classesDto.getSubject());
            classesRepository.saveAndFlush(updClasses);
        }
    }


    @Override
    public void deleteClasses( Long id ) {
        classesRepository.deleteById(id);
    }


    @Override
    public List<ClassesByUserDto> getAllClassesByUser( Long idUser, Date date ) {
        return classesRepository.getAllClassesByUser(idUser, date);
    }
}
