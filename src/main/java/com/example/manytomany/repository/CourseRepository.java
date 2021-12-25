package com.example.manytomany.repository;

import com.example.manytomany.domain.Course;
import com.example.manytomany.dto.CourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("""
            SELECT new com.example.manytomany.dto.CourseDTO(course.id, course.name)
            FROM Course course
            """)
    List<CourseDTO> retrieveAll();

    @Query("""
            SELECT course FROM Course course
            WHERE course.id = :id
            """)
    Optional<Course> retrieveById(Long id);

    @Query("""
            SELECT new com.example.manytomany.dto.CourseDTO(course.id, course.name)
            FROM Course course
            WHERE course.id = :id
            """)
    Optional<CourseDTO> retrieveCourseDTOById(Long id);

    @Query("""
            SELECT new com.example.manytomany.dto.CourseDTO(course.id, course.name)
            FROM Course course
            INNER JOIN course.registrations registrations
            INNER JOIN registrations.student student
            WHERE student.id = :studentId
            """)
    List<CourseDTO> retrieveAllEnrolledCoursesByStudentId(Long studentId);
}
