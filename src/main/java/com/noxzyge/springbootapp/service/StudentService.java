package com.noxzyge.springbootapp.service;

import com.noxzyge.springbootapp.model.Student;
import com.noxzyge.springbootapp.repository.AddressRepository;
import com.noxzyge.springbootapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            addressRepository.deleteAddressesByStudentId(studentId);
            studentRepository.delete(student.get());
        } else {
            throw new RuntimeException("There is no student Against this student ID");
        }
    }

    public Student getStudentById(Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException("Student not found");
        }
    }
}
