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
@Table(name = "teachers")
public class Teacher extends Person{

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "teachers_courses",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    List<Course> teacherCourses = new ArrayList<>();

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    List<Address> addresses = new ArrayList<>();
}
