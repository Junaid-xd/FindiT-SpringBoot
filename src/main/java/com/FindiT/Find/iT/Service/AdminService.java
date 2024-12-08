package com.FindiT.Find.iT.Service;

import com.FindiT.Find.iT.Model.Admin;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    public Admin create(Admin newAdmin);

    public Admin updateAdmin(Admin admin);

    public List<Admin> getAllAdmins();
}





