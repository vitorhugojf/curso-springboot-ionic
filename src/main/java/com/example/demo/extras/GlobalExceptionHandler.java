package com.example.demo.extras;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handleException(Exception e) {
        if (e instanceof ObjectNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardError(e.getMessage(), ((ObjectNotFoundException) e).getTypeOfObject()));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new StandardError(e.getMessage()));
    }
}

class StandardError {
    private String description;
    private String typeOfObject;
    private Date dateOfError;

    public StandardError() {
    }

    public StandardError(String description) {
        this.description = description;
        this.dateOfError = new Date();
    }

    public StandardError(String description, String typeOfObject) {
        this.description = description;
        this.typeOfObject = typeOfObject;
        this.dateOfError = new Date();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfObject() {
        return typeOfObject;
    }

    public void setTypeOfObject(String typeOfObject) {
        this.typeOfObject = typeOfObject;
    }

    public Date getDateOfError() {
        return dateOfError;
    }

    public void setDateOfError(Date dateOfError) {
        this.dateOfError = dateOfError;
    }
}

