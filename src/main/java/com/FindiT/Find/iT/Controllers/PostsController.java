package com.FindiT.Find.iT.Controllers;


import com.FindiT.Find.iT.Model.Post;
import com.FindiT.Find.iT.Model.Users;
import com.FindiT.Find.iT.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data/posts")
@CrossOrigin
public class PostsController {

    @Autowired
    private PostService postService;

    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post newpost){
        return postService.create(newpost);
    }


    @GetMapping("/getPosts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @DeleteMapping("/delete/{postid}")
    public ResponseEntity<String> deletePost(@PathVariable Integer postid) {
        if (!postService.postExists(postid)) { // Check if the post exists
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Post not found with ID: " + postid);
        }
        postService.deletePost(postid); // Perform the delete
        return ResponseEntity.ok("Post deleted with ID: " + postid);
    }
}
