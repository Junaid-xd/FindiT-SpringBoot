package com.FindiT.Find.iT.Service.Impl;

import com.FindiT.Find.iT.Model.Users;
import com.FindiT.Find.iT.Repository.UserRepository;
import com.FindiT.Find.iT.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users create(Users newuser){
        return userRepository.save(newuser);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserByID(Integer userid) {
        Optional<Users> userOptional = userRepository.findById(userid);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new RuntimeException("User not found with ID: " + userid);
        }
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Integer userid) {
        userRepository.deleteById(userid);
        return "Record Deleted with ID: " + userid;
    }


    @Override
    public boolean userExists(Integer userid) {
        return userRepository.existsById(userid);
    }

}
