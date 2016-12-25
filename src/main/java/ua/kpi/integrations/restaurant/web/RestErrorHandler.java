package ua.kpi.integrations.restaurant.web;


import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.kpi.integrations.restaurant.dto.FieldErrorDto;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<FieldErrorDto> processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        return result.getFieldErrors()
                      .stream()
                      .map(FieldErrorDto::fromFieldError)
                      .collect(Collectors.toList());
    }
}
