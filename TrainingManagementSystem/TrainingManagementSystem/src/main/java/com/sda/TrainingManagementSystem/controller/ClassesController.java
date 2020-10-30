package com.sda.TrainingManagementSystem.controller;

import com.sda.TrainingManagementSystem.dto.ClassesByUserDto;
import com.sda.TrainingManagementSystem.dto.ClassesDto;
import com.sda.TrainingManagementSystem.dto.UserDto;
import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @GetMapping("/getClasses")
    public ResponseEntity<List<ClassesDto>> getAll() {
        List<ClassesDto> classesDtoList = classesService.getAll();
        return new ResponseEntity(classesDtoList, HttpStatus.OK);
    }

    @GetMapping("/getClasses/{id}")
    public ResponseEntity<ClassesDto> findById( @PathVariable("id") Long id ) {
        ClassesDto classesDto = classesService.getClassesDtoById(id);
        return new ResponseEntity(classesDto, HttpStatus.OK);
    }

    @GetMapping("/getAllByIdClassUnit/{idClassUnit}")
    public ResponseEntity<List<ClassesDto>> getAllByIdClassUnit(@PathVariable("idClassUnit") Long id){
        List<ClassesDto> classesDtoList = classesService.getAllByClassUnitId(id);
        return new ResponseEntity(classesDtoList,HttpStatus.OK);
    }

    @GetMapping("/getAllClassesByUser/{id}/{date}")
    public ResponseEntity<List<ClassesByUserDto>> getAllClassesByUser(@PathVariable("id") Long idUser, @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        List<ClassesByUserDto> classesByUserDtoList = classesService.getAllClassesByUser( idUser, date);
        return new ResponseEntity<>(classesByUserDtoList,HttpStatus.OK);
    }
    @PostMapping("/addClasses")
    public ResponseEntity addClasses( @RequestBody ClassesDto classesDto ) {
        classesService.addClasses(classesDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/addnewClassesInClassUnit/{id}")
    public ResponseEntity addnewClassesInClassUnit( @RequestBody ClassesDto classesDto, @PathVariable("id") Long idClassUnit ) {
        classesService.addNewClassesInClassUnit(classesDto, idClassUnit);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/linkClassesInClassUnit/{id1}/{id2}")
    public ResponseEntity linkClassesInClassUnit( @PathVariable("id1") Long idClassUnit, @PathVariable("id2") Long idClasses ) {
        classesService.linkClassesInClassUnit(idClassUnit, idClasses);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateClasses")
    public ResponseEntity update( @RequestBody ClassesDto classesDto ) {
        classesService.updateClasses(classesDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteClasses/{id}")
    public ResponseEntity delete( @PathVariable("id") Long id ) {
        classesService.deleteClasses(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
