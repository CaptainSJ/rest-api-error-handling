package dev.captainsj.restapierrorhandling.controller;

import dev.captainsj.restapierrorhandling.model.Student;
import dev.captainsj.restapierrorhandling.service.StudentService;
import dev.captainsj.restapierrorhandling.service.StudentServiceImpl;
import jakarta.validation.Valid;
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
        return studentService.findStudent(id);
    }

    @PostMapping("/add")
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);


    }


}
