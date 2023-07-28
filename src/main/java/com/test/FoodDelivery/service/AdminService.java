package com.test.FoodDelivery.service;

import com.test.FoodDelivery.model.Admin;
import com.test.FoodDelivery.repository.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;

    public String createAdmin(Admin admin) {
        adminRepo.save(admin);
        return "an admin added!!";
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public String deleteAdmin(Admin admin) {
        adminRepo.delete(admin);
        return "admin deleted : "+admin.getAdminEmail();
    }
}
