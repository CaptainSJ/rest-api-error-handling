package dev.captainsj.restapierrorhandling.model;

import dev.captainsj.restapierrorhandling.model.validations.Email;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;

@Entity
@Table(name = "STUDENT")
@ToString
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "NAME")
    private String name;


    @Email
    @Column(name = "EMAIL")
    private String email;

    @NotNull(message = "Standard is mandatory")
    @Column(name = "STANDARD")
    private Stnd std;

    public Student() {

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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Stnd getStd() {
        return std;
    }

    public void setStd(Stnd std) {
        this.std = std;
    }

    public Student(String name, String email, Stnd std) {
        this.name = name;
        this.email = email;
        this.std = std;
    }



}
