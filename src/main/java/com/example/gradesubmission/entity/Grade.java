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
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grade")
public class Grade {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Score
  @Column(name = "score", nullable = false)
  private String score;

  //Many grades belongs to one student
  //optional means grade cannot exits whithout student
  @ManyToOne(optional = false)
  //child table (grade) has the foreing key, and the foreing key of grade table is (student_Id), 
  //references the primary key (id) of student table
  @JoinColumn(name = "student_Id", referencedColumnName = "id")
  private Student student;
}
