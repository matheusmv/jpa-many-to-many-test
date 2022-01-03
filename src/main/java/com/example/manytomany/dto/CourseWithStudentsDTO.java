package com.example.manytomany.dto;

import com.example.manytomany.domain.Course;
import com.example.manytomany.domain.CourseRegistration;

import java.util.List;
import java.util.stream.Collectors;

public record CourseWithStudentsDTO(
        Long id,
        String name,
        List<StudentDTO> students) {

    public CourseWithStudentsDTO(Course course) {
        this(course.getId(), course.getName(), course.getRegistrations().stream()
                .map(CourseRegistration::getStudent)
                .map(StudentDTO::new)
                .collect(Collectors.toList()));
    }
}
