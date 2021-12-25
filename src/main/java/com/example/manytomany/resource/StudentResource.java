package com.example.manytomany.resource;

import com.example.manytomany.resource.response.CourseResponse;
import com.example.manytomany.resource.response.StudentResponse;
import com.example.manytomany.resource.response.StudentWithCoursesResponse;
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
@RequestMapping("/students")
public class StudentResource {

    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public StudentResource(
            StudentService studentService,
            CourseService courseService
    ) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll() {
        var listOfStudents = studentService.findAll()
                .stream()
                .map(StudentResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listOfStudents);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentWithCoursesResponse> findById(@PathVariable Long id) {
        var student = studentService.find(id);
        var listOfCourses = courseService.getAllCoursesByStudentId(student.getId())
                .stream()
                .map(CourseResponse::new)
                .collect(Collectors.toList());

        var studentWithCourses = new StudentWithCoursesResponse(student);
        studentWithCourses.setCourses(listOfCourses);

        return ResponseEntity.ok().body(studentWithCourses);
    }
}
