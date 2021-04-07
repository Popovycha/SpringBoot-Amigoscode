package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//JPA Repository for Data Access Layer
@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    //Select * FROM student WHERE email = ?
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
