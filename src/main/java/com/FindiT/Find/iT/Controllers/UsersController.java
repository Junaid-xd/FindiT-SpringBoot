package com.FindiT.Find.iT.Controllers;

import com.FindiT.Find.iT.Model.TemUsers;
import com.FindiT.Find.iT.Model.Users;
import com.FindiT.Find.iT.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/data/users")
public class UsersController {

    @Autowired
    UserService userService;

    //private List<Users> users = new ArrayList<>();

//    @GetMapping("/getUsers")
//    public ResponseEntity<List<Users>> getUsers() {
//        if (users == null || users.isEmpty()) {
//            return ResponseEntity.noContent().build(); // 204 No Content
//        }
//        return ResponseEntity.ok(users); // 200 OK with the list
//    }

    @PostMapping("/addUser")
    public Users addUser(@RequestBody Users newuser){
        return userService.create(newuser);
    }


    @GetMapping("/yes")
    public String sayHello(){
        return "Hello";
    }


//    @GetMapping("/getID/{id}")
//    public ResponseEntity<Users> getUserByID(@PathVariable int id) {
//        for (Users user : users) {
//            if (user.getUserID() == id) {
//                return ResponseEntity.ok(user);
//            }
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
}
