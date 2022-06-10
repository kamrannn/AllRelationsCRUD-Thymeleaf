package com.noxzyge.springbootapp;

import com.noxzyge.springbootapp.model.Admin;
import com.noxzyge.springbootapp.model.Course;
import com.noxzyge.springbootapp.repository.AdminRepository;
import com.noxzyge.springbootapp.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CourseRepository courseRepository, AdminRepository adminRepository, BCryptPasswordEncoder encoder) {
        return args -> {

            Course course1 = new Course();
            course1.setId(1);
            course1.setCourseName("English");
            course1.setTotalCreditHours(3);
            courseRepository.save(course1);

            Course course2 = new Course();
            course2.setId(2);
            course2.setCourseName("Chemistry");
            course2.setTotalCreditHours(4);
            courseRepository.save(course2);

            Course course3 = new Course();
            course3.setId(3);
            course3.setCourseName("Nuclear Physics");
            course3.setTotalCreditHours(5);
            courseRepository.save(course3);


            Optional<Admin> admin = adminRepository.findByUsername("admin");
            if (!admin.isPresent()) {
                Admin newAdmin = new Admin();
                newAdmin.setFirstName("Super");
                newAdmin.setLastName("Admin");
                newAdmin.setEmail("admin@gmail.com");
                newAdmin.setUsername("admin");
                newAdmin.setPassword(encoder.encode("password"));
                newAdmin.setAge(30);
                adminRepository.save(newAdmin);
            }
        };
    }
}
