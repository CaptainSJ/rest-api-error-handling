package dev.captainsj.restapierrorhandling.errorHandeling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

public abstract class ApiSubError {
}

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ApiValidationError(String Object, String message) {
        this.object = object;
        this.message = message;

    }


}
