package com.noxzyge.springbootapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student extends Person {

    private String degree;
    @OneToOne
    RollNumber rollNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_courses",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    List<Course> studentCourses = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, targetEntity = Address.class)
    List<Address> addresses = new ArrayList<>();

}
