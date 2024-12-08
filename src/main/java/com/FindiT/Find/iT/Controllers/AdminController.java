package com.FindiT.Find.iT.Controllers;


import com.FindiT.Find.iT.Model.Admin;
import com.FindiT.Find.iT.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data/admins")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin newadmin){
        return adminService.create(newadmin);
    }

    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }

    @GetMapping("/getAdmins")
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }
}
