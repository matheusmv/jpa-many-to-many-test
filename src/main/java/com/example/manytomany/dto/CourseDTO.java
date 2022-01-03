package com.example.manytomany.dto;

import com.example.manytomany.domain.Course;

public record CourseDTO(
        Long id,
        String name) {

    public CourseDTO(Course course) {
        this(course.getId(), course.getName());
    }
}
