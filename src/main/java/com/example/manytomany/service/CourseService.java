package com.example.manytomany.service;

import com.example.manytomany.domain.Course;
import com.example.manytomany.repository.CourseRepository;
import com.example.manytomany.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
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

    public List<Course> getAllCoursesByStudentId(Long id) {
        return courseRepository.retrieveAllCoursesByStudentId(id);
    }
}
