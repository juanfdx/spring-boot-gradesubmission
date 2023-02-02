package com.example.gradesubmission.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotBlank(message = "Name cannot be blank")
  @NonNull
  @Column(name = "name", nullable = false)
  private String name;

  
  @Past(message = "The birth date must be in the past")
  @NonNull
  @Column(name = "birth_date", nullable = false)
  private LocalDate birthDate;

  //this is parent table of "grade" table, we have to put @OneToMany(mappedBy = "parent table")
  //the two tables are connected in both ways, so we can access data from both sides
  @JsonIgnore// must put @JsonIgnore here
  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)//Cascade, if student is deleted so their grades will be
  private List<Grade> grades;
}
