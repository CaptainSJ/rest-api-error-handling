package dev.captainsj.restapierrorhandling.errorHandeling;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import jakarta.validation.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class ApiError {
    private HttpStatusCode status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime localDateTime;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    public ApiError() {
        this.localDateTime = LocalDateTime.now();
    }

    public ApiError(HttpStatusCode statusCode) {
        this();
        this.status = statusCode;
    }

    public ApiError(HttpStatusCode status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected Error!";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public ApiError(HttpStatusCode status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }


    public void addSubError(ApiSubError subError) {

        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }

        subErrors.add(subError);
    }

    private void addValidationErrors(String object, String field, Object rejectedValue, String message) {
        addSubError(new ApiValidationError(object, field, rejectedValue, message));
    }

    private void addValidationErrors(String object, String message) {
        addSubError(new ApiValidationError(object, message));

    }

    private void addValidationErrors(ConstraintViolation<?> constraintViolation) {
        this.addValidationErrors(constraintViolation.getRootBeanClass().getSimpleName(), constraintViolation.getPropertyPath().toString(), constraintViolation.getInvalidValue(), constraintViolation.getMessage());
    }

    public void addValidationErrors(Set<ConstraintViolation<?>> constraints) {
        constraints.forEach(this::addValidationErrors);

    }



    public void addValidationErrors(List<FieldError> globalError) {
        globalError.forEach(this::addValidationErrors);
    }

    private void addValidationErrors(FieldError fieldError) {

        addValidationErrors(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue(),
                fieldError.getDefaultMessage()
        );
    }

//    public void addValidationErrors(List<FieldError> fieldErrors) {
//        fieldErrors.forEach(this::addValidationErrors);
//    }
//
//    private void addValidationErrors(FieldError fieldError) {
//        addValidationErrors(
//                fieldError.getObjectName(),
//                fieldError.getField(),
//                fieldError.getRejectedValue(),
//                fieldError.getDefaultMessage()
//        );
//    }
}
