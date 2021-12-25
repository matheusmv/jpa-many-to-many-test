package com.example.manytomany.dto;

import com.example.manytomany.domain.Course;
import com.example.manytomany.domain.CourseRegistration;
import com.example.manytomany.domain.Student;

public class EnrollInCourseDTO {

    private Long studentId;
    private Long courseId;

    public EnrollInCourseDTO(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public CourseRegistration toRegistration() {
        var registration = new CourseRegistration();

        registration.setId(null);
        registration.setStudent(new Student(studentId, null));
        registration.setCourse(new Course(courseId, null));

        return registration;
    }
}
