package dev.captainsj.restapierrorhandling.controller;

import dev.captainsj.restapierrorhandling.model.Student;
import dev.captainsj.restapierrorhandling.service.StudentService;
import dev.captainsj.restapierrorhandling.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(value = "id") Long id) {
        Student response = studentService.findStudent(id);

        return response;


    }


}
