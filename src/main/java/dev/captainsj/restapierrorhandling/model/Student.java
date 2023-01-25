package dev.captainsj.restapierrorhandling.model;

import dev.captainsj.restapierrorhandling.model.customValidation.Email;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
public class Student {

    @Id
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "NAME")
    private String name;

    @NotBlank(message = "DOB is mandatory")
    @Column(name = "DATE_OF_BIRTH")
    private Date dob;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @NotBlank(message = "Standard is mandatory")
    @Column(name = "STANDARD")
    private Stnd std;

}
