package dev.captainsj.restapierrorhandling.repository;

import dev.captainsj.restapierrorhandling.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
