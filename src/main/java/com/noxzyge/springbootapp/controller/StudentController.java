package com.noxzyge.springbootapp.controller;

import com.noxzyge.springbootapp.model.Student;
import com.noxzyge.springbootapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<Student> studentList() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getById")
    public Student studentList(@RequestParam(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/new")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam(name = "id") Integer id) {
        studentService.deleteStudent(id);
        return "Student is successfully deleted";
    }
}
