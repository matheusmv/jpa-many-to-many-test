package com.example.manytomany.service;

import com.example.manytomany.domain.Student;
import com.example.manytomany.dto.StudentDTO;
import com.example.manytomany.dto.StudentWithCoursesDTO;
import com.example.manytomany.repository.StudentRepository;
import com.example.manytomany.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> findAll() {
        return studentRepository.retrieveAll();
    }

    public Student find(Long id) {
        return studentRepository.retrieveById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format("Object with id %d not found in %s.", id, Student.class.getSimpleName())));
    }

    public Student save(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    public List<StudentDTO> getAllStudentsByCourseId(Long id) {
        return studentRepository.retrieveAllEnrolledStudentsByCourseId(id);
    }

    public StudentWithCoursesDTO getStudentWithCourses(Long id) {
        return studentRepository.retrieveStudentWithCoursesByStudentId(id)
                .map(StudentWithCoursesDTO::new)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format("Object with id %d not found in %s.", id, Student.class.getSimpleName())));
    }
}
