package dev.captainsj.restapierrorhandling.service;

import dev.captainsj.restapierrorhandling.model.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {

   public Student findStudent(Long id);

    Student addStudent(Student student);
}
