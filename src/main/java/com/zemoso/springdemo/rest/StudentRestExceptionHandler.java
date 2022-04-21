package com.zemoso.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// This is for global exception handling, where large projects have multiple controllers and a global excption handling
// is required.

// @Controller advice is a real time use of the AOP , where the it can be used to process a task at the controller level.
@ControllerAdvice
public class StudentRestExceptionHandler {

    //add exception handling code.
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe){
        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exe.getMessage());
        error.setTimeStamp(System.currentTimeMillis());




        //return a ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // Add another Exception handler : Generic

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exe){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exe.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);


    }

}
