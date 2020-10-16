package com.sda.TrainingManagementSystem.repository;

import com.sda.TrainingManagementSystem.model.ClassUnit;
import com.sda.TrainingManagementSystem.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassUnitRepository extends JpaRepository<ClassUnit, Long> {

}
