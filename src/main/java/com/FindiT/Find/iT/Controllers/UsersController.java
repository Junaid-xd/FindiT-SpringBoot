package com.FindiT.Find.iT.Controllers;

import com.FindiT.Find.iT.Model.Users;
import com.FindiT.Find.iT.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data/users")
@CrossOrigin
public class UsersController {

    @Autowired
    private UserService userService;


    @GetMapping("/getUsers")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public Users addUser(@RequestBody Users newuser){
        return userService.create(newuser);
    }

    @GetMapping("/id/{userid}")
    public ResponseEntity<Users> getUserByID(@PathVariable Integer userid) {
        Users user = userService.getUserByID(userid);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PutMapping("/update")
    public Users updateUser(@RequestBody Users user){
        return userService.updateUser(user);
    }



    @DeleteMapping("/delete/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userid) {
        if (!userService.userExists(userid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with ID: " + userid);
        }
        userService.deleteUser(userid);
        return ResponseEntity.ok("User deleted with ID: " + userid);
    }
}
