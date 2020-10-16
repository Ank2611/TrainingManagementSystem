package com.sda.TrainingManagementSystem.repository;

import com.sda.TrainingManagementSystem.model.Classes;
import com.sda.TrainingManagementSystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value="SELECT r.*, c.*, u.*  \n" +
            "FROM trainingmanagementsystem.registration r \n" +
            "join trainingmanagementsystem.courses c on r.course_id = c.id\n" +
            "join trainingmanagementsystem.users u on u.id = r.user_id where u.id= :id", nativeQuery = true)
    List<Course> findAllCoursesByUser(@Param("id") Long id);

}
