package com.lukinhasssss.ecommerce.config.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    ResponseEntity<List<StandardErrorMessage>> validation(MethodArgumentNotValidException e) {
        List<StandardErrorMessage> errors = new ArrayList<>();

        List<FieldError> fieldErrors = e.getFieldErrors();
        fieldErrors.forEach(error -> errors.add(new StandardErrorMessage(error.getField(), error.getDefaultMessage())));

        return ResponseEntity.badRequest().body(errors);
    }

//    private final MessageSource messageSource;
//
//    public ErrorHandler(MessageSource messageSource) {
//        this.messageSource = messageSource;
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public List<StandardErrorMessage> validationErrors(MethodArgumentNotValidException exception) {
//        List<StandardErrorMessage> errors = new ArrayList<>();
//
//        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
//        fieldErrors.forEach(e -> {
//            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
//            StandardErrorMessage error = new StandardErrorMessage(e.getField(), message);
//            errors.add(error);
//        });
//
//        return errors;
//    }

}
