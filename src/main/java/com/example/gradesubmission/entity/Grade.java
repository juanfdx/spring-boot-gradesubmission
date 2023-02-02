package com.example.gradesubmission.entity;

import com.example.gradesubmission.validation.Score;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grade", uniqueConstraints = {
  //only unique value is admited,  student_id course_id per must be unique, to
  //prevent student has two scores on same course
  @UniqueConstraint(columnNames = {"student_id", "course_id"})
})
public class Grade {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Score
  @Column(name = "score", nullable = false)
  private String score;

  //Many grades belongs to one student, this is the child and the owner of the relationship
  //optional means grade cannot exits whithout student
  @ManyToOne(optional = false)
  //this is child table (grade) (owner of the relationship) has the foreing key, and the foreing key of grade table is (student_Id), 
  //references the primary key (id) of student table
  @JoinColumn(name = "student_Id", referencedColumnName = "id")
  private Student student;

  //table grade also depends on table course
  @ManyToOne(optional = false)
  @JoinColumn(name = "course_Id", referencedColumnName = "id")
  private Course course;

}
