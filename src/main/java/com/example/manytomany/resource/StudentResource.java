package com.example.manytomany.resource;

import com.example.manytomany.dto.CourseDTO;
import com.example.manytomany.dto.StudentDTO;
import com.example.manytomany.dto.StudentWithCoursesDTO;
import com.example.manytomany.service.CourseService;
import com.example.manytomany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<List<StudentDTO>> findAll() {
        var listOfStudents = studentService.findAll();

        return ResponseEntity.ok().body(listOfStudents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentWithCoursesDTO> findById(@PathVariable Long id) {
        var studentWithCourses = studentService.getStudentWithCourses(id);

        return ResponseEntity.ok().body(studentWithCourses);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<CourseDTO>> getEnrolledCourses(@PathVariable Long id) {
        var listOfEnrolledCourses = courseService.getAllCoursesByStudentId(id);

        return ResponseEntity.ok().body(listOfEnrolledCourses);
    }
}
