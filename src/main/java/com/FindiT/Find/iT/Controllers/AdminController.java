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


    // =========== Since There is not any updation functionality of admin, so below function is commented =========

//    @PutMapping("/update")
//    public ResponseEntity<?> updateAdmin(@RequestBody Admin admin){
//
//        if(adminService.adminExists(admin.getAdminID())){
//            return ResponseEntity.ok(adminService.updateAdmin(admin));
//        }
//        else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such admin exists with ID: "+ admin.getAdminID());
//        }
//
//    }






    // =========== Since There is not any updation functionality of admin, so below function is commented =========


//    @PutMapping("/updateAdminProfilePicture")
//    public ResponseEntity<?> updateAdminProfilePicture(@RequestParam("adminid") Integer adminID,
//                                                       @RequestParam("file") MultipartFile file) throws IOException {
//
//        if(adminService.adminExists(adminID)){
//            Admin adminToUpdate = adminService.getAdminByID(adminID);
//
//            String cloudImageLink = null;
//            cloudImageLink = cloudinaryService.uploadFile(file);
//            if(cloudImageLink==null){
//                return  ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Error occurred while uploading image on cloud.");
//            }
//            else {
//                adminToUpdate.setImgPath(cloudImageLink);
//
//                return ResponseEntity.ok(adminService.updateAdmin(adminToUpdate));
//            }
//        }
//        else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such Admin exists with ID: "+ adminID);
//        }
//
//    }

}
