/*
package com.noxzyge.springbootapp.controller;

import com.noxzyge.springbootapp.model.Address;
import com.noxzyge.springbootapp.model.RollNumber;
import com.noxzyge.springbootapp.model.Student;
import com.noxzyge.springbootapp.repository.AddressRepository;
import com.noxzyge.springbootapp.repository.CourseRepository;
import com.noxzyge.springbootapp.repository.RollNumberRepository;
import com.noxzyge.springbootapp.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    RollNumberRepository rollNumberRepository;

    @Autowired
    CourseRepository courseRepository;

    private static Integer studentId = 0;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("studentsList", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/add/student")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseRepository.findAll());
        return "add-student";
    }

    @PostMapping("/add/student")
    public String addStudent(@Valid Student student, Model model) {
        Student std = studentService.saveStudent(student);
        studentId = std.getId();
        return "add-student-address";
    }

    @PostMapping("/add/student/address")
    public String addStudentAddress(@RequestParam(value = "address1", required = false) String address1,
                                    @RequestParam(value = "address2", required = false) String address2,
                                    @RequestParam(value = "address3", required = false) String address3) {
        Student student = studentService.getStudentById(studentId);

        RollNumber rollNumber = new RollNumber();
        RollNumber savedRollNumber = rollNumberRepository.save(rollNumber);
        student.setRollNumber(savedRollNumber);
        student = studentService.saveStudent(student);

        if (!address1.isEmpty()) {
            Address address = new Address();
            address.setStudent(student);
            address.setAddress(address1);
            Address savedAddress1 = addressRepository.save(address);
            student.getAddresses().add(savedAddress1);
            student = studentService.saveStudent(student);
        }
        if (!address2.isEmpty()) {
            Address address = new Address();
            address.setStudent(student);
            address.setAddress(address2);
            Address savedAddress2 = addressRepository.save(address);
            student.getAddresses().add(savedAddress2);
            student = studentService.saveStudent(student);
        }
        if (!address3.isEmpty()) {
            Address address = new Address();
            address.setStudent(student);
            address.setAddress(address3);
            Address savedAddress3 = addressRepository.save(address);
            student.getAddresses().add(savedAddress3);
            studentService.saveStudent(student);
        }
        return "redirect:/";
    }

    @GetMapping("/student/viewAddresses/{id}")
    public String viewAddresses(@PathVariable(name = "id") Integer studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("addresses", student.getAddresses());
        return "view-student-addresses";
    }

    @GetMapping("/student/viewCourses/{id}")
    public String viewCourses(@PathVariable(name = "id") Integer studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("courses", student.getStudentCourses());
        return "view-student-courses";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") Integer studentId, Model model) {
        studentService.deleteStudent(studentId);
        return "redirect:/";
    }
}
*/
