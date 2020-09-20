package com.sda.TrainingManagementSystem.service;

import com.sda.TrainingManagementSystem.dto.ParticipantRegistrationDto;

import java.util.List;

public interface ParticipantRegistrationService {
    ParticipantRegistrationDto getParticipantDto(Long id);
    List<ParticipantRegistrationDto> getAll();
    void addParticipantRegistration(ParticipantRegistrationDto participantRegistrationDto);
    void updateParticipant(ParticipantRegistrationDto participantRegistrationDto);
    void deleteParticipant(Long id);

}
