package com.FindiT.Find.iT.Service.Impl;

import com.FindiT.Find.iT.Model.Users;
import com.FindiT.Find.iT.Repository.UserRepository;
import com.FindiT.Find.iT.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Users create(Users newuser){
        return userRepository.save(newuser);
    }
}
