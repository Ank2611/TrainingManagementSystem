package com.sda.TrainingManagementSystem.repository;

import com.sda.TrainingManagementSystem.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {

}
