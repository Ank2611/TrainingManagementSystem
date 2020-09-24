package com.sda.TrainingManagementSystem.controller;

import com.sda.TrainingManagementSystem.dto.ClassesDto;
import com.sda.TrainingManagementSystem.dto.UserDto;
import com.sda.TrainingManagementSystem.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @GetMapping("/getClasses")
    public ResponseEntity<List<ClassesDto>> getAll(){
        List<ClassesDto> classesDtoList = classesService.getAll();
        return new ResponseEntity(classesDtoList, HttpStatus.OK);
    }

    @GetMapping("/getClasses/{id}")
    public ResponseEntity<ClassesDto> findById(@PathVariable("id") Long id){
        ClassesDto classesDto = classesService.getClassesDtoById(id);
        return new ResponseEntity(classesDto, HttpStatus.OK);
    }

    @PostMapping("/addClasses")
    public ResponseEntity addClasses(@RequestBody ClassesDto classesDto){
        classesService.addClasses(classesDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateClasses")
    public ResponseEntity update(@RequestBody ClassesDto classesDto){
        classesService.updateClasses(classesDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteClasses/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        classesService.deleteClasses(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
