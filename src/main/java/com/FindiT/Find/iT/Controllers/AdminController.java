
package com.FindiT.Find.iT.Controllers;


import com.FindiT.Find.iT.Model.Admin;
import com.FindiT.Find.iT.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/data/admins")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/addAdmin")
    public ResponseEntity<?> addAdmin(@RequestBody Admin newadmin){
        return ResponseEntity.ok(adminService.create(newadmin));
    }


    @GetMapping("/getAdmins")
    public ResponseEntity<?> getAllAdmins(){
        List<Admin> allAdmins = adminService.getAllAdmins();
        if(!allAdmins.isEmpty()){
            return ResponseEntity.ok(allAdmins);
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Currently no admins in Database");
        }
    }

}
