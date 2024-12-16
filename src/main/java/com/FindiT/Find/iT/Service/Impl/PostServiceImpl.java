package com.FindiT.Find.iT.Service.Impl;

import com.FindiT.Find.iT.Model.Post;
import com.FindiT.Find.iT.Repository.PostRepository;
import com.FindiT.Find.iT.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
}
