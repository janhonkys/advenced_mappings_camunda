package com.luv2code.springboot.cruddemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    // add exception handling code here
    @ExceptionHandler   //exception handler method
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){      //EmployeeErrorResponse - type of the response body   EmployeeNotFoundException - exception type to handle

        //create a EmployeeErrorResponse
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //add another exception handler ... to catch any axception (catch all)

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc){

        //create a EmployeeErrorResponse
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}
