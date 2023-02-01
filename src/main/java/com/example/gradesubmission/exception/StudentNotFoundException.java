package com.example.gradesubmission.exception;

public class StudentNotFoundException extends RuntimeException {
  

  public StudentNotFoundException(Long id) {
    super("The Student id '" + id + "' does not exist in our records");
  }

}
