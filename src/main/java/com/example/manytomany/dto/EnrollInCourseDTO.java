package com.example.manytomany.dto;

import com.example.manytomany.domain.Course;
import com.example.manytomany.domain.CourseRegistration;
import com.example.manytomany.domain.Student;

public record EnrollInCourseDTO(
        Long studentId,
        Long courseId) {

    public CourseRegistration toRegistration() {
        var registration = new CourseRegistration();

        registration.setId(null);
        registration.setStudent(new Student(studentId, null));
        registration.setCourse(new Course(courseId, null));

        return registration;
    }
}
