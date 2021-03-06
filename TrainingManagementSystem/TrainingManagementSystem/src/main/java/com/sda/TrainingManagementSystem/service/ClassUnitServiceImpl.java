package com.sda.TrainingManagementSystem.service;


import com.sda.TrainingManagementSystem.dto.*;
import com.sda.TrainingManagementSystem.model.*;
import com.sda.TrainingManagementSystem.repository.ClassUnitRepository;
import com.sda.TrainingManagementSystem.repository.CourseRepository;
import com.sda.TrainingManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassUnitServiceImpl implements ClassUnitService {

    @Autowired
    private ClassUnitRepository classUnitRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ClassUnitDto getClassUnitById( Long id ) {
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
            return classUnitDto;
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
    public List<ClassUnitDto> getAllByIdCourse( Long id ) {
        Optional<Course> foundCourse = courseRepository.findById(id);
        if(foundCourse.isPresent()){
            Course course = foundCourse.get();
            List<ClassUnit> classUnitList = course.getClassUnitList();
            List<ClassUnitDto> classUnitDtoList = new ArrayList<>();
            for(ClassUnit classUnit:classUnitList){
                ClassUnitDto classUnitDto = new ClassUnitDto();
                classUnitDto.setId(classUnit.getId());
                classUnitDto.setName(classUnit.getName());
                classUnitDtoList.add(classUnitDto);
              }
            return classUnitDtoList;
        }

        return null;
    }

    @Override
    public List<ClassUnitByUserDto> getAllClassUnitByUser( Long idUser ) {
         return classUnitRepository.getAllClassUnitByUser(idUser);
    }

    @Override
    public void addClassUnit( ClassUnitDto classUnitDto ) {
        ClassUnit newClassUnit = new ClassUnit();
        newClassUnit.setName(classUnitDto.getName());
        classUnitRepository.save(newClassUnit);
    }

    @Override
    public void addNewClassUnitInCourse( ClassUnitDto classUnitDto, Long idCourse ) {
        ClassUnit newClassUnit = new ClassUnit();
        newClassUnit.setName(classUnitDto.getName());
        classUnitRepository.save(newClassUnit);

        Optional<Course> foundcourse = courseRepository.findById(idCourse);
        if(foundcourse.isPresent()){
           Course course = foundcourse.get();
           course.getClassUnitList().add(newClassUnit);
           courseRepository.save(course);
        }
    }

    @Override
    public void linkClassUnitInCourse( Long idClassUnit, Long idCourse ) {
        Optional<ClassUnit> foundClassUnit = classUnitRepository.findById(idClassUnit);
        if(foundClassUnit.isPresent()){
            ClassUnit classUnit = foundClassUnit.get();
            Optional<Course> foundcourse = courseRepository.findById(idCourse);
            if(foundcourse.isPresent()){
                Course course = foundcourse.get();
                course.getClassUnitList().add(classUnit);
                courseRepository.save(course);
            }
        }
    }


    @Override
    public void updateClassUnit( ClassUnitDto classUnitDto ) {
        Optional<ClassUnit> foundClassUnit = classUnitRepository.findById(classUnitDto.getId());
        if(foundClassUnit.isPresent()) {
            ClassUnit updClassUnit = foundClassUnit.get();
            updClassUnit.setName(classUnitDto.getName());
            classUnitRepository.saveAndFlush(updClassUnit);
        }
    }

    @Override
    public void deleteClassUnit( Long id ) {
        classUnitRepository.deleteById(id);
    }

}
