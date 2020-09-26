package com.sda.TrainingManagementSystem.service;


import com.sda.TrainingManagementSystem.dto.ClassUnitDto;
import com.sda.TrainingManagementSystem.dto.ClassesDto;
import com.sda.TrainingManagementSystem.model.ClassUnit;
import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.model.Course;
import com.sda.TrainingManagementSystem.repository.ClassUnitRepository;
import com.sda.TrainingManagementSystem.repository.CourseRepository;
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
    public void linkClassUnitInCourse( Long idClassUnitDto, Long idCourse ) {
        Optional<ClassUnit> foundClassUnit = classUnitRepository.findById(idClassUnitDto);
        if(foundClassUnit.isPresent()){
            ClassUnit classUnit = foundClassUnit.get();
            classUnit.setName(classUnit.getName());
        }

        Optional<Course> foundcourse = courseRepository.findById(idCourse);
        if(foundcourse.isPresent()){
            Course course = foundcourse.get();
//            ClassUnit existingclassUnit =
//            course.getClassUnitList().add(classUnit);
            courseRepository.save(course);
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
