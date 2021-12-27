package com.example.manytomany.repository;

import com.example.manytomany.domain.Student;
import com.example.manytomany.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("""
            SELECT new com.example.manytomany.dto.StudentDTO(student.id, student.name)
            FROM Student student
            """)
    List<StudentDTO> retrieveAll();

    @Query("""
            SELECT student FROM Student student
            WHERE student.id = :id
            """)
    Optional<Student> retrieveById(Long id);

    @Query("""
            SELECT student FROM Student student
            JOIN FETCH student.registrations registrations
            JOIN FETCH registrations.course
            WHERE student.id = :id
            """)
    Optional<Student> retrieveStudentWithCoursesByStudentId(Long id);

    @Query("""
            SELECT new com.example.manytomany.dto.StudentDTO(student.id, student.name)
            FROM Student student
            WHERE student.id = :id
            """)
    Optional<StudentDTO> retrieveStudentDTOById(Long id);

    @Query("""
            SELECT new com.example.manytomany.dto.StudentDTO(student.id, student.name)
            FROM Student student
            INNER JOIN student.registrations registrations
            INNER JOIN registrations.course course
            WHERE course.id = :courseId
            """)
    List<StudentDTO> retrieveAllEnrolledStudentsByCourseId(Long courseId);
}
