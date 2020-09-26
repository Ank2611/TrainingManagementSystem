package com.sda.TrainingManagementSystem.controller;

import com.sda.TrainingManagementSystem.dto.CourseDto;
import com.sda.TrainingManagementSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourses")
    public ResponseEntity<List<CourseDto>> getAll(){
        List<CourseDto> courseDtoList = courseService.getAll();
        return new ResponseEntity(courseDtoList, HttpStatus.OK);
    }

    @GetMapping("/getCourse/{id}")
    public ResponseEntity<CourseDto> findById(@PathVariable("id") Long id){
        CourseDto courseDto = courseService.getCourseDtoById(id);
        return new ResponseEntity(courseDto, HttpStatus.OK);
    }

    @GetMapping("/findAllCourseByUser/{id}")
    public ResponseEntity<CourseDto> findAllCoursesByUser(@PathVariable("id") Long id){
        List<CourseDto> courseDtoList = courseService.findAllCoursesByUser(id);
        return  new ResponseEntity(courseDtoList, HttpStatus.OK);
    }

    @PostMapping("/addCourse")
    public ResponseEntity addCourse(@RequestBody CourseDto courseDto){
        courseService.addCourse(courseDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateCourse")
    public ResponseEntity updateCourse(@RequestBody CourseDto courseDto){
        courseService.updateCourse(courseDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
