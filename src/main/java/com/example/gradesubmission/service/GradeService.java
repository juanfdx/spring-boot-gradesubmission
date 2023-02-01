package com.example.gradesubmission.service;

import com.example.gradesubmission.entity.Grade;

public interface GradeService {
  Grade getGrade(Long studentId, Long courseId);
  Grade saveGrade(Grade grade, Long studentId, Long courseId);
  Grade updateGrade(String score, Long studentId, Long courseId);
  void deleteGrade(Long studentId, Long courseId);
}