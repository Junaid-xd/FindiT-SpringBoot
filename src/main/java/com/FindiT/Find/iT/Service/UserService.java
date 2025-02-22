package com.FindiT.Find.iT.Service;

import com.FindiT.Find.iT.Model.Users;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    public Users create(Users user);

    public List<Users> getAllUsers();

    public Users getUserByID(Integer userid);

    public Users updateUser(Users user);

    public String deleteUser(Integer userid);

    public boolean userExists(Integer userid);

    public boolean usernameAlreadyExists(String username);
//      previous
//    public boolean existsByUsernameAndPassword(String username, String password);
//      updated
    public Users findByUsernameAndPassword(String username, String password);


}
