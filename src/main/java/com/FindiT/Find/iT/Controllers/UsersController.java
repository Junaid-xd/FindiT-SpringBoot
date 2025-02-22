

package com.FindiT.Find.iT.Controllers;

import com.FindiT.Find.iT.Model.Users;
import com.FindiT.Find.iT.Service.CloudinaryService;
import com.FindiT.Find.iT.Service.PostService;
import com.FindiT.Find.iT.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/data/users")
@CrossOrigin    
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;
    private final CloudinaryService cloudinaryService;


    public UsersController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @GetMapping("/getUsers")
    public ResponseEntity<?> getAllUsers(){
        List<Users> allUsers = userService.getAllUsers();
        if(!allUsers.isEmpty()){
            return ResponseEntity.ok(allUsers);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Currently no users in database");
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody Users newuser){
        if(userService.usernameAlreadyExists(newuser.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exixts");
        }
        else {
            return ResponseEntity.ok(userService.create(newuser));
        }
    }

    @GetMapping("/id/{userid}")
    public ResponseEntity<?> getUserByID(@PathVariable Integer userid) {

        if (userService.userExists(userid)) {
            return ResponseEntity.ok(userService.getUserByID(userid));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not founc with ID: "+ userid);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody Users user){

        if(!userService.userExists(user.getUserID())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + user.getUserID() + " not found.");
        }

        return ResponseEntity.ok().body(userService.updateUser(user));
    }


    @DeleteMapping("/delete/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userid) {
        if (!userService.userExists(userid)) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with ID: " + userid);
        }
        postService.deletePostsByUserID(userid);
        userService.deleteUser(userid);
        return ResponseEntity.ok("User deleted with ID: " + userid);
    }


    @PutMapping("/updateProfilePicture")
    public ResponseEntity<?> updateProfilePicture(@RequestParam("file") MultipartFile file,
                                                  @RequestParam("userid") Integer userID) throws IOException {

        if(userService.userExists(userID)){
            Users userToUpdate = userService.getUserByID(userID);
            System.out.println("User to update: "+ userToUpdate.getUserID());
            String cloudImagelink =  null;
            cloudImagelink = cloudinaryService.uploadFile(file);

            if(cloudImagelink != null){
                userToUpdate.setImgPath(cloudImagelink);
            }

            return ResponseEntity.ok().body(userService.updateUser(userToUpdate));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID: "+ userID+" not found.");
    }


    @GetMapping("/verifyUsername/{username}")
    public boolean usernameAlreadyExists(@PathVariable String username) {
        return userService.usernameAlreadyExists(username);
    }
//     previous
//    @GetMapping("/verifyCredentials")
//    public boolean verifyCredentials(@RequestParam String username,
//                                     @RequestParam String password){
//        return userService.existsByUsernameAndPassword(username, password);
//
//    }

//    updated
@GetMapping("/getUserByCredentials")
public ResponseEntity<Users> getUserByCredentials(@RequestParam String username,
                                                 @RequestParam String password) {
    Users user = userService.findByUsernameAndPassword(username, password);
    if (user != null) {
        return ResponseEntity.ok(user); // 200 OK with user object
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // 401 Unauthorized
    }
}

}