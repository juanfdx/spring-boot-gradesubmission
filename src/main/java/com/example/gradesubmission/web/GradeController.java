package com.example.gradesubmission.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gradesubmission.entity.Grade;
import com.example.gradesubmission.service.GradeService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/grade")
public class GradeController {
  
  GradeService gradeService;

  @GetMapping("/student/{studentId}/course/{courseId}")
  public ResponseEntity<Grade> getGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
    return new ResponseEntity<>(gradeService.getGrade(studentId, courseId) ,HttpStatus.OK);
  }

  @PostMapping("/student/{studentId}/course/{courseId}")
  public ResponseEntity<Grade> saveGrade(@RequestBody Grade grade, @PathVariable Long studentId, @PathVariable Long courseId) {
    return new ResponseEntity<>(gradeService.saveGrade(grade, studentId, courseId) ,HttpStatus.CREATED);
  }
}
