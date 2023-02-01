package com.example.gradesubmission.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.gradesubmission.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long> {
  //our own query method: (find grade by student id)
  //what to do , based on, and spring boot do the rest
  Grade findByStudentId(Long studentId);
}
