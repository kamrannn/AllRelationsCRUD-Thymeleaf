package com.noxzyge.springbootapp.controller;

import com.noxzyge.springbootapp.model.Teacher;
import com.noxzyge.springbootapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;


    @GetMapping("/all")
    public List<Teacher> teacherList() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/getById")
    public Teacher teacherList(@RequestParam(name = "id") Integer id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/new")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @PutMapping("/update")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @DeleteMapping("/delete")
    public String deleteTeacher(@RequestParam(name = "id") Integer id) {
        teacherService.deleteTeacher(id);
        return "Teacher is successfully deleted";
    }
}
