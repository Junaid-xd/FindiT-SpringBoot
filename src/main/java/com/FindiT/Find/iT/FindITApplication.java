package com.FindiT.Find.iT;

import com.FindiT.Find.iT.Model.Post;
import com.FindiT.Find.iT.Model.Users;
import com.FindiT.Find.iT.Repository.UserRepository;
import com.FindiT.Find.iT.Service.UserService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FindITApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindITApplication.class, args);


//		UserRepository userRepository;
//
//		Users user1 = new Users();
//		user1.setUserID(1);
//		user1.setUsername("Junaid");
//		user1.setContact("03220281979");
//
//		Post p1 = new Post();
//		p1.setPostID(1);
//		p1.setDescription("hello g");
//		p1.setLocation("Lahore");
//		p1.setStatus(1);
//		p1.setImgPath(null);
//		p1.setProductName("wallet");
//		p1.setUser(user1);
//
//
//		Post p2 = new Post();
//		p2.setPostID(2);
//		p2.setDescription("heheh");
//		p2.setLocation("Multan");
//		p2.setStatus(2);
//		p2.setImgPath(null);
//		p2.setProductName("Lamp");
//		p2.setUser(user1);
//
//		List<Post> allPosts = new ArrayList<>();
//		allPosts.add(p1);
//		allPosts.add(p2);
//
//		user1.setPosts(allPosts);
//
//
//		userRepository.save(user1);


	}

}
