package com.example.gradesubmission.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gradesubmission.entity.Grade;
import com.example.gradesubmission.entity.Student;
import com.example.gradesubmission.repository.GradeRepository;
import com.example.gradesubmission.repository.StudentRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {


  GradeRepository gradeRepository;
  StudentRepository studentRepository;

  @Override
  public Grade getGrade(Long studentId, Long courseId) {
    return gradeRepository.findByStudentId(studentId);
  }

  @Override
  public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
    //has to assign grade to a student before save the grade, so we get the student
    Student student = StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId);
    grade.setStudent(student);
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
