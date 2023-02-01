package com.example.gradesubmission.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Subject cannot be blank")
  @NonNull
  @Column(name = "subject", nullable = false)
  private String subject;

  @NotBlank(message = "Course code cannot be blank")
  @NonNull
  @Column(name = "code", nullable = false, unique = true)
  private String code;

  @NotBlank(message = "Description cannot be blank")
  @NonNull
  @Column(name = "description", nullable = false)
  private String description;
}
