package com.noxzyge.springbootapp.controller;

import com.noxzyge.springbootapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    CourseService courseService;

    @GetMapping("/")
    public String home() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (username.equalsIgnoreCase("anonymousUser")) {
            return "home";
        } else {
            return "redirect:/dashboard";
        }
    }
}

