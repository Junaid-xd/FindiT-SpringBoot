package com.FindiT.Find.iT.Repository;

import com.FindiT.Find.iT.Model.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
