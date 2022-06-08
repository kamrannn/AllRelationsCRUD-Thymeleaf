package com.noxzyge.springbootapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "course_name")
    private String courseName;

    private int totalCreditHours;

    @ManyToMany(mappedBy = "studentCourses")
    private List<Student> students = new ArrayList<>();

    @ManyToMany(mappedBy = "teacherCourses")
    private List<Teacher> teachers = new ArrayList<>();
}
