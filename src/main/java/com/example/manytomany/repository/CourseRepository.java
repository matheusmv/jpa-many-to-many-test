package com.example.manytomany.repository;

import com.example.manytomany.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT course FROM Course course")
    List<Course> retrieveAll();

    @Query("SELECT course FROM Course course " +
            "WHERE course.id = :id")
    Optional<Course> retrieveById(Long id);

    @Query("SELECT course FROM Course course " +
            "JOIN FETCH course.registrations registrations " +
            "JOIN FETCH registrations.student student " +
            "WHERE student.id = :id")
    List<Course> retrieveAllCoursesByStudentId(Long id);
}
