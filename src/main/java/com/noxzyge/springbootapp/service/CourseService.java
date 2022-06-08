package com.noxzyge.springbootapp.service;

import com.noxzyge.springbootapp.model.Course;
import com.noxzyge.springbootapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public boolean deleteCourse(Integer courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            courseRepository.delete(course.get());
            return true;
        } else {
            return false;
        }
    }

    public Course getCourseById(Integer courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            return course.get();
        } else {
            throw new RuntimeException("There is no course Against this CourseId");
        }
    }

}
