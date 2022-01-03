package com.example.manytomany.dto;

import com.example.manytomany.domain.CourseRegistration;
import com.example.manytomany.domain.Student;

import java.util.List;
import java.util.stream.Collectors;

public record StudentWithCoursesDTO(
        Long id,
        String name,
        List<CourseDTO> courses) {

    public StudentWithCoursesDTO(Student student) {
        this(student.getId(), student.getName(), student.getRegistrations().stream()
                .map(CourseRegistration::getCourse)
                .map(CourseDTO::new)
                .collect(Collectors.toList()));
    }
}
