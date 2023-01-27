package dev.captainsj.restapierrorhandling.service;

import dev.captainsj.restapierrorhandling.errorHandeling.exceptions.EntityNotFoundException;
import dev.captainsj.restapierrorhandling.model.Student;
import dev.captainsj.restapierrorhandling.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student findStudent(Long id) {

        Optional<Student> student = studentRepository.findById(id);

        if (student.isEmpty())
            throw new EntityNotFoundException(Student.class, "id", id.toString());

        return student.get();

    }
}
