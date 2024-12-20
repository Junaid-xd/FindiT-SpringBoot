

package com.FindiT.Find.iT.Controllers;

import com.FindiT.Find.iT.Model.Post;
import com.FindiT.Find.iT.Model.PostWithDescription;
import com.FindiT.Find.iT.Model.PostWithImage;
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
    public ResponseEntity<?> addPostWithDescription(
            @RequestParam("productName") String productName,
            @RequestParam("status") Integer status,
            @RequestParam("location") String location,
            @RequestParam("description") String description,
            @RequestParam("userid") Integer userID) {

        if (userService.userExists(userID)) {
            Users postMakerUser = userService.getUserByID(userID);

            PostWithDescription newPost = new PostWithDescription(
                    productName, status, location, postMakerUser, description
            );

            return ResponseEntity.ok(postService.create(newPost));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID: " + userID + " not found.");
        }
    }

    @PostMapping("/addPostWithImage")
    public ResponseEntity<?> addPostWithImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("productName") String productName,
            @RequestParam("status") Integer status,
            @RequestParam("location") String location,
            @RequestParam("userid") Integer userID) throws IOException {

        if (userService.userExists(userID)) {
            String cloudImagePath = cloudinaryService.uploadFile(file);
            if (cloudImagePath == null) {
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
                        .body("Error occurred while uploading image to the cloud.");
            }

            Users postMakerUser = userService.getUserByID(userID);

            PostWithImage newPost = new PostWithImage(
                    productName, status, location, postMakerUser, cloudImagePath
            );

            return ResponseEntity.ok(postService.create(newPost));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID: " + userID + " not found.");
        }
    }

    @GetMapping("/getPosts")
    public ResponseEntity<?> getAllPosts() {
        List<Post> allPosts = postService.getAllPosts();

        if (!allPosts.isEmpty()) {
            return ResponseEntity.ok(allPosts);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Currently no posts in the database.");
        }
    }

    @GetMapping("/userId/{userID}")
    public ResponseEntity<?> getPostsByUserID(@PathVariable Integer userID) {
        if (userService.userExists(userID)) {
            List<Post> userPosts = postService.getPostsByUserID(userID);

            if (userPosts.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("This user has no posts yet.");
            } else {
                return ResponseEntity.ok(userPosts);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID: " + userID + " does not exist.");
        }
    }

    @DeleteMapping("/delete/{postid}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postid) {
        if (!postService.postExists(postid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No such post exists with ID: " + postid);
        }
        postService.deletePost(postid);
        return ResponseEntity.ok("Post deleted with ID: " + postid);
    }

    @PutMapping("/recover/{postid}")
    public ResponseEntity<?> recoverPost(@PathVariable Integer postid){
        if (postService.postExists(postid)){
            Post postToBeRecoverd = postService.getPostByPostID(postid);

            postToBeRecoverd.setStatus(3);

            return ResponseEntity.ok(postService.updatePost(postToBeRecoverd));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post don't exist with postID: "+ postid);
        }
    }
}

