package com.FindiT.Find.iT.Service;

import com.FindiT.Find.iT.Model.Users;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    public Users create(Users user);
}
