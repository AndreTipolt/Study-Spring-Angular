package tipolt.andre.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import tipolt.andre.backend.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class ControllerAdivceApplication {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){

        return "Error: " + resourceNotFoundException.getMessage();
    }
}
