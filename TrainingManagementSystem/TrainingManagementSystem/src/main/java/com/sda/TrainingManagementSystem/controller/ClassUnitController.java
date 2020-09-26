package com.sda.TrainingManagementSystem.controller;

import com.sda.TrainingManagementSystem.dto.ClassUnitDto;
import com.sda.TrainingManagementSystem.model.ClassUnit;
import com.sda.TrainingManagementSystem.service.ClassUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "classUnit")
public class ClassUnitController {

    @Autowired
    private ClassUnitService classUnitService;

    @GetMapping("/getClassUnits")
    public ResponseEntity<List<ClassUnitDto>> getAll() {
        List<ClassUnitDto> classUnitDtoList = classUnitService.getAll();
        return new ResponseEntity(classUnitDtoList, HttpStatus.OK);
    }

    @GetMapping("/getClassUnit/{id}")
    public ResponseEntity<ClassUnitDto> findById( @PathVariable("id") Long id ) {
        ClassUnitDto classUnitDto = classUnitService.getClassUnitById(id);
        return new ResponseEntity(classUnitDto, HttpStatus.OK);
    }

    @PostMapping("/addClassUnit")
    public ResponseEntity addClassUnit(@RequestBody ClassUnitDto classUnitDto){
        classUnitService.addClassUnit(classUnitDto);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("addNewClassUnitInCourse/{id}")
    public ResponseEntity addNewClassUnitInCourse(@RequestBody ClassUnitDto classUnitDto,@PathVariable("id") Long idCourse){
        classUnitService.addNewClassUnitInCourse(classUnitDto, idCourse);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateClassUnit")
    public ResponseEntity updateClassUnit(@RequestBody ClassUnitDto classUnitDto){
        classUnitService.updateClassUnit(classUnitDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteClassUnit/{id}")
    public ResponseEntity deleteClassUnit(@PathVariable("id") Long id){
        classUnitService.deleteClassUnit(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
