package com.noxzyge.springbootapp;

import com.noxzyge.springbootapp.model.Course;
import com.noxzyge.springbootapp.repository.CourseRepository;
import com.noxzyge.springbootapp.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class CourseServiceTests {
    @Autowired
    CourseService courseService;

    @MockBean
    CourseRepository courseRepository;

    @Test
    public void addCourseTest() {
        Course course = new Course();
        course.setId(1);
        course.setCourseName("Nuclear Physics");
        when(courseRepository.save(course)).thenReturn(course);
        assertEquals(course, courseService.addCourse(course));
    }


    @Test
    public void getAllCoursesTest() {
        Course course = new Course();
        course.setId(1);
        course.setCourseName("Nuclear Physics");

        List<Course> coursesList = new ArrayList<>();
        coursesList.add(course);
        when(courseRepository.findAll()).thenReturn(coursesList);
        assertEquals(coursesList, courseService.getAllCourses());
    }

    @Test
    public void getCourseByIdTest() {
        Course course = new Course();
        course.setId(1);
        course.setCourseName("Nuclear Physics");
        when(courseRepository.findById(1)).thenReturn(Optional.of(course));
        assertEquals(course, courseService.getCourseById(1));
    }


    @Test
    public void deleteCourseTest() {
        Course course = new Course();
        course.setId(1);
        course.setCourseName("Nuclear Physics");

        when(courseRepository.findById(1)).thenReturn(Optional.of(course));
        assertTrue(courseService.deleteCourse(1));
    }
}
