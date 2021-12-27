package com.example.manytomany.service;

import com.example.manytomany.domain.Course;
import com.example.manytomany.dto.CourseDTO;
import com.example.manytomany.dto.CourseWithStudentsDTO;
import com.example.manytomany.repository.CourseRepository;
import com.example.manytomany.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> findAll() {
        return courseRepository.retrieveAll();
    }

    public Course find(Long id) {
        return courseRepository.retrieveById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format("Object with id %d not found in %s.", id, Course.class.getSimpleName())));
    }

    public Course save(Course course) {
        course.setId(null);
        return courseRepository.save(course);
    }

    public List<CourseDTO> getAllCoursesByStudentId(Long id) {
        return courseRepository.retrieveAllEnrolledCoursesByStudentId(id);
    }

    public CourseWithStudentsDTO getCourseWithStudents(Long id) {
        return courseRepository.retrieveCourseWithStudentsByCourseId(id)
                .map(CourseWithStudentsDTO::new)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format("Object with id %d not found in %s.", id, Course.class.getSimpleName())));
    }
}
