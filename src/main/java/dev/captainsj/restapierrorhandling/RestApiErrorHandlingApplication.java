package dev.captainsj.restapierrorhandling;

import dev.captainsj.restapierrorhandling.model.Stnd;
import dev.captainsj.restapierrorhandling.model.Student;
import dev.captainsj.restapierrorhandling.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class RestApiErrorHandlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiErrorHandlingApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {

            Student student = new Student("Saurabh", "saurabh@jjs.in", Stnd.TENTH);
            repository.save(student);
        };
    }

}
