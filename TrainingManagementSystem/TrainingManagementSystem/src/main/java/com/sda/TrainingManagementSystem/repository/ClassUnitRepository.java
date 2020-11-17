package com.sda.TrainingManagementSystem.repository;

import com.sda.TrainingManagementSystem.dto.ClassUnitByUserDto;
import com.sda.TrainingManagementSystem.dto.ClassUnitDto;
import com.sda.TrainingManagementSystem.model.ClassUnit;
import com.sda.TrainingManagementSystem.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassUnitRepository extends JpaRepository<ClassUnit, Long> {

    @Query("select new com.sda.TrainingManagementSystem.dto.ClassUnitByUserDto( cu.id as idClassUnit,cu.name as classUnitName) from ClassUnit as cu\n"
    +"join cu.courses as c\n"+
    "join c.participantRegistrationList as p\n"+
    "where p.user.id= :idUser")
    List<ClassUnitByUserDto> getAllClassUnitByUser( @Param("idUser") Long idUser);
}
