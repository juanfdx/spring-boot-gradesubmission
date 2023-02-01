package com.example.gradesubmission.service;

import org.springframework.stereotype.Service;

import com.example.gradesubmission.entity.Grade;
import com.example.gradesubmission.repository.GradeRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {


  GradeRepository gradeRepository;


  @Override
  public Grade getGrade(Long studentId, Long courseId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
    return gradeRepository.save(grade);
  }

  @Override
  public Grade updateGrade(String score, Long studentId, Long courseId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteGrade(Long studentId, Long courseId) {
    // TODO Auto-generated method stub
    
  }
  
}
