package com.example.manytomany.dto;

import com.example.manytomany.domain.Course;
import com.example.manytomany.domain.CourseRegistration;

import java.util.List;
import java.util.stream.Collectors;

public class CourseWithStudentsDTO {

    private Long id;
    private String name;
    private List<StudentDTO> students;

    public CourseWithStudentsDTO(Long id, String name, List<StudentDTO> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public CourseWithStudentsDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.students = course.getRegistrations().stream()
                .map(CourseRegistration::getStudent)
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
}
