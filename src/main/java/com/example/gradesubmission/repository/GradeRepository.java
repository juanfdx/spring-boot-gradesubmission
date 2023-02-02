package com.example.gradesubmission.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.gradesubmission.entity.Grade;

import jakarta.transaction.Transactional;

public interface GradeRepository extends CrudRepository<Grade, Long> {
  //our own query method: (find grade by student id)
  //what to do , based on, And or Or if, and spring boot do the rest
  Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);
  List<Grade> findByStudentId(Long studentId);
  List<Grade> findByCourseId(Long courseId);
  @Transactional//custom method that we create are no transactional by defaul
  void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
}
