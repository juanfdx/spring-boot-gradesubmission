package com.example.gradesubmission.service;

import java.util.List;
import java.util.Set;

import com.example.gradesubmission.entity.Course;
import com.example.gradesubmission.entity.Student;

public interface StudentService {
  Student getStudent(Long id);
  Student saveStudent(Student student);
  void deleteStudent(Long id);
  List<Student> getStudents();
  Set<Course> getEnrolledCourses(Long id);
}
