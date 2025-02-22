package com.FindiT.Find.iT.Repository;

import com.FindiT.Find.iT.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    boolean existsByUsername(String username);
//    previous
//    boolean existsByUsernameAndPassword(String username, String password);
//    updated
     Users findByUsernameAndPassword(String username, String password);

}
