package com.example.gradesubmission.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gradesubmission.entity.Student;
import com.example.gradesubmission.service.StudentService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
  

  StudentService studentService;


  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudent(@PathVariable Long id) {
    return new ResponseEntity<>(studentService.getStudent(id) ,HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
    return new ResponseEntity<>(studentService.saveStudent(student) ,HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id) {
    student.setId(id);
    return new ResponseEntity<>(studentService.saveStudent(student) ,HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Student>> getStudents() {
    return new ResponseEntity<>(studentService.getStudents() ,HttpStatus.OK);
  }
}
