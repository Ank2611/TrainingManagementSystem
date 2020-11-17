package com.sda.TrainingManagementSystem.repository;


import com.sda.TrainingManagementSystem.model.ParticipantRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRegistrationRepository extends JpaRepository<ParticipantRegistration, Long> {
}
