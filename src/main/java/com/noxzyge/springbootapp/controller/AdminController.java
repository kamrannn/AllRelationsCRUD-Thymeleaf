package com.noxzyge.springbootapp.controller;

import com.noxzyge.springbootapp.model.Admin;
import com.noxzyge.springbootapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;


    @GetMapping("/all")
    public List<Admin> adminList() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/getById")
    public Admin adminList(@RequestParam(name = "id") Integer id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/new")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @DeleteMapping("/delete")
    public String deleteAdmin(@RequestParam(name = "id") Integer id) {
        adminService.deleteAdmin(id);
        return "Admin is successfully deleted";
    }
}
