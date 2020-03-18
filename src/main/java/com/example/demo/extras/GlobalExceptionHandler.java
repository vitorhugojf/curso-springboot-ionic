package com.example.demo.extras;

import org.springframework.dao.EmptyResultDataAccessException;
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandardError(e.getMessage()));
        }
        if(e instanceof EmptyResultDataAccessException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardError(e.getMessage()));
        }
        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardError(e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new StandardError(e.getMessage()));
    }
}

class StandardError {
    private String description;
    private Date dateOfError;

    public StandardError() {
    }

    public StandardError(String description) {
        this.description = description;
        this.dateOfError = new Date();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfError() {
        return dateOfError;
    }

    public void setDateOfError(Date dateOfError) {
        this.dateOfError = dateOfError;
    }
}

