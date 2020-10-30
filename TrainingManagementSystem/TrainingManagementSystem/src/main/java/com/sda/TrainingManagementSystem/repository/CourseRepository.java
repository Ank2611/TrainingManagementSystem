package com.sda.TrainingManagementSystem.repository;


import com.sda.TrainingManagementSystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value="select c.id,c.name from courses c\n" +
            "join registration r on r.course_id = c.id where r.user_id= :id", nativeQuery = true)

    List<Course> findAllCoursesByUser(@Param("id") Long id);

}
