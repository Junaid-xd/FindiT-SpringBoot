package com.FindiT.Find.iT.Service.Impl;

import com.FindiT.Find.iT.Model.Admin;
import com.FindiT.Find.iT.Model.Users;
import com.FindiT.Find.iT.Repository.AdminRepository;
import com.FindiT.Find.iT.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin create(Admin newadmin){
        return adminRepository.save(newadmin);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public boolean adminExists(Integer adminID) {
        return adminRepository.existsById(adminID);
    }

    @Override
    public Admin getAdminByID(Integer adminID) {
        Optional<Admin> adminOptional = adminRepository.findById(adminID);
        if (adminOptional.isPresent()) {
            return adminOptional.get();
        } else {
            throw new RuntimeException("Admin not found with ID: " + adminID);
        }
    }
}




