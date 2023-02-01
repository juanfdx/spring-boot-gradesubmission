package com.example.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gradesubmission.entity.Course;
import com.example.gradesubmission.exception.CourseNotFoundException;
import com.example.gradesubmission.repository.CourseRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {


  CourseRepository courseRepository;


  @Override
  public Course getCourse(Long id) {
    Optional<Course> course = courseRepository.findById(id);
    return unwrapCourse(course, id);
  }

  @Override
  public Course saveCourse(Course course) {
    return courseRepository.save(course);
  }

  @Override
  public void deleteCourse(Long id) {
    courseRepository.deleteById(id); 
  }

  @Override
  public List<Course> getCourses() {
    return (List<Course>) courseRepository.findAll();
  }


  //check if Course is present
  static Course unwrapCourse(Optional<Course> entity, Long id) {
    if (entity.isPresent()) { return entity.get(); }
    else throw new CourseNotFoundException(id); 
  } 
  
}
