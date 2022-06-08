package com.noxzyge.springbootapp.controller;

import com.noxzyge.springbootapp.model.Course;
import com.noxzyge.springbootapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/create")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        return "add-course";
    }

    @PostMapping("/create")
    public String addCourse(@Valid Course course, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("course", new Course());
            return "add-course";
        } else {
            courseService.addCourse(course);
            return "redirect:/";
        }
    }


    @GetMapping("/update/{id}")
    public String updateCourse(@PathVariable(name = "id") Integer courseId, Model model) {
        model.addAttribute("course", courseService.getCourseById(courseId));
        return "update-course";
    }

    @PostMapping("/update")
    public String updateCourse(@Valid Course course, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update-course";
        } else {
            courseService.addCourse(course);
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable(name = "id") Integer courseId) {
        courseService.deleteCourse(courseId);
        return "redirect:/";
    }
}
