package ua.kpi.integrations.restaurant.dto;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.FieldError;


@Data
@Accessors(chain = true)
public class FieldErrorDto {

    private String field;
    private String message;

    public static FieldErrorDto fromFieldError(FieldError fieldError) {
        return new FieldErrorDto().setField(fieldError.getField())
                                   .setMessage(fieldError.getDefaultMessage());
    }
}
