

package com.FindiT.Find.iT.Service.Impl;

import com.FindiT.Find.iT.Model.Post;
import com.FindiT.Find.iT.Model.Users;
import com.FindiT.Find.iT.Repository.PostRepository;
import com.FindiT.Find.iT.Service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    @Override
    public Post create(Post newpost){
        return postRepository.save(newpost);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public String deletePost(Integer postid) {
        postRepository.deleteById(postid);
        return "Post Deleted with ID: "+postid;
    }

    @Override
    public boolean postExists(Integer postid) {
        return postRepository.existsById(postid);
    }

    @Override
    public List<Post> getPostsByUserID(Integer userID) {
        return postRepository.findByUser_UserID(userID);
    }

    @Override
    public Post getPostByPostID(Integer postid) {
        Optional<Post> postOptional = postRepository.findById(postid);
        if (postOptional.isPresent()) {
            return postOptional.get();
        } else {
            throw new RuntimeException("Post not found with ID: " + postid);
        }
    }

    @Override
    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public void deletePostsByUserID(Integer userid) {
        postRepository.deleteByUser_UserID(userid);
    }
}
