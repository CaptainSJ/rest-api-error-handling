package dev.captainsj.restapierrorhandling.errorHandeling;

import dev.captainsj.restapierrorhandling.errorHandeling.exceptions.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError, ex);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                                      WebRequest request) {
        ApiError apiError = new ApiError(BAD_REQUEST);

        apiError.setMessage(String.format("The parameter '%s' of value '%s' could not be converted to " +
                "type '%s'", ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName()));

        apiError.setDebugMessage(ex.getMessage());
        return buildResponseEntity(apiError, ex);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handelAllOtherExceptions(RuntimeException ex) {
        ApiError apiError = new ApiError(INTERNAL_SERVER_ERROR, ex);

        return buildResponseEntity(apiError, ex);


    }

        private ResponseEntity<Object> buildResponseEntity(ApiError apiError, Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }



}
