package com.FindiT.Find.iT.Repository;

import com.FindiT.Find.iT.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    boolean existsByUsername(String username);
    boolean existsByUsernameAndPassword(String username, String password);
}
