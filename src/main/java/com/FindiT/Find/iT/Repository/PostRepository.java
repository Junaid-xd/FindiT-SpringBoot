package com.FindiT.Find.iT.Repository;

import com.FindiT.Find.iT.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser_UserID(Integer userID);
}
