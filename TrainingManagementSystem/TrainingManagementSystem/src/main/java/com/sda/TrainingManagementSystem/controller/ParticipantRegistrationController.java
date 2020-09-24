package com.sda.TrainingManagementSystem.controller;

import com.sda.TrainingManagementSystem.dto.ParticipantRegistrationDto;
import com.sda.TrainingManagementSystem.model.ParticipantRegistration;
import com.sda.TrainingManagementSystem.service.ParticipantRegistrationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="participant")
public class ParticipantRegistrationController {

    @Autowired
    private ParticipantRegistrationService service;

    @GetMapping("/getParticipantRegistrations")
    public ResponseEntity<List<ParticipantRegistrationDto>> getAll(){
        List<ParticipantRegistrationDto> participantRegistrationDtoList = service.getAll();
        return new ResponseEntity(participantRegistrationDtoList, HttpStatus.OK);
    }

    @GetMapping("/getParticipantRegistration/{id}")
    public ResponseEntity<ParticipantRegistrationDto> findById(@PathVariable("id") Long id){
        ParticipantRegistrationDto participantRegistrationDto = service.getParticipantDto(id);
        return new ResponseEntity(participantRegistrationDto, HttpStatus.OK);
    }

    @PostMapping("/addParticipantRegistration")
    public ResponseEntity addParticipant(@RequestBody ParticipantRegistrationDto participantRegistrationDto){
        service.addParticipantRegistration(participantRegistrationDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateParticipantRegistration")
    public ResponseEntity updateParticipant(@RequestBody ParticipantRegistrationDto participantRegistrationDto){
        service.updateParticipant(participantRegistrationDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.deleteParticipant(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
