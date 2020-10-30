package com.sda.TrainingManagementSystem.repository;

import com.sda.TrainingManagementSystem.dto.ClassesByUserDto;
import com.sda.TrainingManagementSystem.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {

    @Query("select new com.sda.TrainingManagementSystem.dto.ClassesByUserDto(cu.name as classUnitName, cls.subject as classesSubject, cls.date as classesDate) from Classes as cls\n" +
            "join cls.classUnit as cu\n" +
            "join cu.courses as c\n" +
            "join c.participantRegistrationList as p\n" +
            "where p.user.id= :idUser and cls.date= :date")
    List<ClassesByUserDto> getAllClassesByUser( @Param("idUser") Long idUser, @Param("date") Date date );
}
