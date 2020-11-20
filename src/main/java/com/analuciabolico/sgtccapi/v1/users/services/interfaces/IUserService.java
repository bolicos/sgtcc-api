package com.analuciabolico.sgtccapi.v1.users.services.interfaces;

import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.users.dtos.UserRequest;
import com.analuciabolico.sgtccapi.v1.users.model.User;
import org.springframework.data.domain.Sort;

public interface IUserService {

    ResourceCreated save(UserRequest userRequest);

    User findByUsername(String username);

    List<User> findAll(Sort sort);

}
