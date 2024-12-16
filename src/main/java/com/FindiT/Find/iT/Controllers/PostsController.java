package com.FindiT.Find.iT.Controllers;


import com.FindiT.Find.iT.Model.Post;
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
@RequestMapping("/data/posts")
@CrossOrigin
public class PostsController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    private final CloudinaryService cloudinaryService;

    public PostsController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }


    @PostMapping("/addPostWithDescription")
    public ResponseEntity<?> addPostWithDescription(@RequestParam("productName") String productName,
                                       @RequestParam("status") Integer status,
                                       @RequestParam("location") String location,
                                       @RequestParam("description") String description,
                                       @RequestParam("userid") Integer userID){

        if(userService.userExists(userID)){
            Post newpost = new Post();
            newpost.setImgPath(null);
            newpost.setProductName(productName);
            newpost.setDescription(description);
            newpost.setStatus(status);
            newpost.setLocation(location);

            Users postMakerUser = userService.getUserByID(userID);
            newpost.setUser(postMakerUser);

            return ResponseEntity.ok(postService.create(newpost));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID: "+ userID+ " not found.");
        }
    }




    @PostMapping("/addPostWithImage")
    public ResponseEntity<?> addPostByImage(@RequestParam("file") MultipartFile file,
                               @RequestParam("productName") String productName,
                               @RequestParam("status") Integer status,
                               @RequestParam("location") String location,
                               @RequestParam("userid") Integer userID ) throws IOException {

        if(userService.userExists(userID)){

            String cloudImagePath = null;
            Post newpost = new Post();
            newpost.setDescription(null);
            newpost.setProductName(productName);
            newpost.setStatus(status);
            newpost.setLocation(location);

            Users postMakerUser = userService.getUserByID(userID);
            newpost.setUser(postMakerUser);

            cloudImagePath = cloudinaryService.uploadFile(file);
            if(cloudImagePath==null){
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Error occurred while uploading image at cloud");
            }
            newpost.setImgPath(cloudImagePath);


            return ResponseEntity.ok(postService.create(newpost));

        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: "+ userID);
        }
    }





    @GetMapping("/getPosts")
    public ResponseEntity<?> getAllPosts(){

        List<Post> allPosts = postService.getAllPosts();

        if(!allPosts.isEmpty()){
            return ResponseEntity.ok(allPosts);
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Currently no posts in Database");
        }
    }


    @GetMapping("/userId/{userID}")
    public ResponseEntity<?> getPostsByUserID(@PathVariable Integer userID) {

        if(userService.userExists(userID)){
            List<Post> userPosts = postService.getPostsByUserID(userID);

            if(userPosts.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("This user don't have any posts yet.");
            }
            else{
                return ResponseEntity.ok(userPosts);
            }
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with userID: "+ userID+" do not exist.");
        }
    }


    @DeleteMapping("/delete/{postid}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postid) {
        if (!postService.postExists(postid)) { // Check if the post exists
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No such post exists with ID: " + postid);
        }
        postService.deletePost(postid); // Perform the delete
        return ResponseEntity.ok("Post deleted with ID: " + postid);
    }
}
