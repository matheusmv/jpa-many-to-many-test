package com.example.manytomany.repository;

import com.example.manytomany.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT DISTINCT student FROM Student student " +
            "JOIN FETCH student.registrations registrations " +
            "JOIN FETCH registrations.course")
    List<Student> retrieveAll();

    @Query("SELECT DISTINCT student FROM Student student " +
            "JOIN FETCH student.registrations registrations " +
            "JOIN FETCH registrations.course course " +
            "WHERE student.id = :id")
    Optional<Student> retrieveById(Long id);

    @Query("SELECT DISTINCT student FROM Student student " +
            "JOIN FETCH student.registrations registrations " +
            "JOIN FETCH registrations.course course " +
            "WHERE course.id = :id")
    List<Student> retrieveAllStudentsByCourseId(Long id);
}
