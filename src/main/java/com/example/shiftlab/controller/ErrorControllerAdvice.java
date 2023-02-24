package com.example.shiftlab.controller;

import com.example.shiftlab.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorControllerAdvice extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;

    @Autowired
    public ErrorControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        Map<String, Object> body = new HashMap<>();
        body.put("message", message);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleItemNotFoundException(){
        return handleCustomException(HttpStatus.NOT_FOUND, "item.not-found");
    }

    @ExceptionHandler(TypeNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleTagNotFoundException(){
        return handleCustomException(HttpStatus.NOT_FOUND, "type.not-found");
    }

    @ExceptionHandler(PropertyValueNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePropertyValueNotFoundException(){
        return handleCustomException(HttpStatus.NOT_FOUND, "property.value.not-found");
    }

    @ExceptionHandler(ItemWithSerialNumberAlreadyExistException.class)
    public ResponseEntity<Map<String, Object>> handleItemWithSerialNumberAlreadyExist(){
        return handleCustomException(HttpStatus.BAD_REQUEST, "item.serial-number.already-exist");
    }

    @ExceptionHandler(ItemAlreadyHavePropertyValueException.class)
    public ResponseEntity<Map<String, Object>> handleItemAlreadyHavePropertyValueException(){
        return handleCustomException(HttpStatus.BAD_REQUEST, "item.property.already-have-value");
    }

    private String getErrorMessage(String code){
        return messageSource.getMessage(code, null, Locale.ENGLISH);
    }

    private ResponseEntity<Map<String, Object>> handleCustomException(HttpStatus status, String code) {
        Map<String, Object> message = new HashMap<>();
        message.put("message", getErrorMessage(code));
        return ResponseEntity.status(status).body(message);
    }
}
