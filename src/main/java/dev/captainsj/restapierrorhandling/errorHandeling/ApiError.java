package dev.captainsj.restapierrorhandling.errorHandeling;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApiError {
    private HttpStatusCode status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime localDateTime;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subError;

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

    public void addSubError() {

    }

}
