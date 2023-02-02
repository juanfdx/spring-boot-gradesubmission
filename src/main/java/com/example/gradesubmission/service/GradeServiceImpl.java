package com.example.gradesubmission.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gradesubmission.entity.Course;
import com.example.gradesubmission.entity.Grade;
import com.example.gradesubmission.entity.Student;
import com.example.gradesubmission.exception.GradeNotFoundException;
import com.example.gradesubmission.repository.CourseRepository;
import com.example.gradesubmission.repository.GradeRepository;
import com.example.gradesubmission.repository.StudentRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {


  GradeRepository gradeRepository;
  StudentRepository studentRepository;
  CourseRepository courseRepository;


  @Override
  public Grade getGrade(Long studentId, Long courseId) {
    Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
    return unwrapGrade(grade, studentId, courseId);
  }

  @Override
  public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
    //has to assign grade to a student before save the grade, so we get the student
    Student student = StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId);
    Course course = CourseServiceImpl.unwrapCourse(courseRepository.findById(courseId), courseId);
    grade.setStudent(student);
    grade.setCourse(course);
    return gradeRepository.save(grade);
  }

  @Override
  public Grade updateGrade(String score, Long studentId, Long courseId) {
    Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
    Grade unwrappedGrade = unwrapGrade(grade, studentId, courseId);
    unwrappedGrade.setScore(score);// set new score
    return gradeRepository.save(unwrappedGrade);//so spring boot updates when save
}
 
  @Override
  public void deleteGrade(Long studentId, Long courseId) {
    gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);   
  }

  @Override
  public List<Grade> getStudentGrades(Long studentId) {
    return gradeRepository.findByStudentId(studentId);
  }

  @Override
  public List<Grade> getCourseGrades(Long courseId) {
    return gradeRepository.findByCourseId(courseId);
  }

  @Override
  public List<Grade> getAllGrades() {
    return (List<Grade>) gradeRepository.findAll();
  }


  static Grade unwrapGrade(Optional<Grade> entity, Long studentId, Long courseId) {
    if (entity.isPresent()) return entity.get();
    else throw new GradeNotFoundException(studentId, courseId);
}
  
}
