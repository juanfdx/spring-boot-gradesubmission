package com.example.gradesubmission;

import java.util.Arrays;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.gradesubmission.exception.ErrorResponse;
import com.example.gradesubmission.exception.StudentNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
  
  @ExceptionHandler(StudentNotFoundException.class)
  public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex) {
    ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(ex.getLocalizedMessage()));
    return new ResponseEntity<>(errorResponse ,HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(EmptyResultDataAccessException.class)
  public ResponseEntity<Object> handleDataAccessException(EmptyResultDataAccessException ex) {
    ErrorResponse errorResponse = new ErrorResponse(Arrays.asList("Cannot delete non-existing resource"));
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }
}
