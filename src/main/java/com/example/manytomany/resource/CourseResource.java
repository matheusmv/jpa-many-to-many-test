package com.example.manytomany.resource;

import com.example.manytomany.resource.response.CourseResponse;
import com.example.manytomany.resource.response.CourseWithStudentsResponse;
import com.example.manytomany.resource.response.StudentResponse;
import com.example.manytomany.service.CourseService;
import com.example.manytomany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseResource {

    private final CourseService courseService;
    private final StudentService studentService;

    @Autowired
    public CourseResource(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> findAll() {
        var listOfCourses = courseService.findAll()
                .stream()
                .map(CourseResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listOfCourses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseWithStudentsResponse> findById(@PathVariable Long id) {
        var course = courseService.find(id);
        var listOfStudents = studentService.getAllStudentsByCourseId(course.getId())
                .stream()
                .map(StudentResponse::new)
                .collect(Collectors.toList());

        var courseWithStudents = new CourseWithStudentsResponse(course);
        courseWithStudents.setStudents(listOfStudents);

        return ResponseEntity.ok().body(courseWithStudents);
    }
}
