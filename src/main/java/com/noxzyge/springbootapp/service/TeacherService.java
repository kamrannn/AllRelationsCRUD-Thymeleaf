package com.noxzyge.springbootapp.service;

import com.noxzyge.springbootapp.model.Teacher;
import com.noxzyge.springbootapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;


    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        if (teacher.isPresent()) {
            teacherRepository.delete(teacher.get());
        } else {
            throw new RuntimeException("There is no teacher Against this teacher ID");
        }
    }

    public Teacher getTeacherById(Integer teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        if (teacher.isPresent()) {
            return teacher.get();
        } else {
            throw new RuntimeException("Teacher not found");
        }
    }
}
