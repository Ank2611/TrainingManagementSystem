package com.sda.TrainingManagementSystem.repository;

import com.sda.TrainingManagementSystem.model.Course;
import com.sda.TrainingManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users u where u.type= :type", nativeQuery = true)
    List<User> findByType( @Param("type") String type );


}
