package com.sda.TrainingManagementSystem.repository;

import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.model.ParticipantRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRegistrationRepository extends JpaRepository<ParticipantRegistration, Long> {

}
