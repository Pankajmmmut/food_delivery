package com.test.FoodDelivery.controller;

import com.test.FoodDelivery.model.Admin;
import com.test.FoodDelivery.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("admin")
    public String createAdmin(@RequestBody Admin admin){
        return adminService.createAdmin(admin);
    }

    @GetMapping("admins")
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }
    @DeleteMapping("admin")
    public String deleteAdmin(@RequestBody Admin admin ){
        return adminService.deleteAdmin(admin);
    }

}
