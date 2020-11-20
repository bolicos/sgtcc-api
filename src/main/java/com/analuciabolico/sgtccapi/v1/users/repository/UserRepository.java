package com.analuciabolico.sgtccapi.v1.users.repository;

import com.analuciabolico.sgtccapi.v1.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
