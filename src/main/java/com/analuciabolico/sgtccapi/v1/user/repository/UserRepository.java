package com.analuciabolico.sgtccapi.v1.user.repository;

import com.analuciabolico.sgtccapi.v1.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
