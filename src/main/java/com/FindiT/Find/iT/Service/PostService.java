package com.FindiT.Find.iT.Service;


import com.FindiT.Find.iT.Model.Post;
import com.FindiT.Find.iT.Model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public Post create(Post newpost);

    public List<Post> getAllPosts();

    public String deletePost(Integer postid);

    public boolean postExists(Integer postid);
}
