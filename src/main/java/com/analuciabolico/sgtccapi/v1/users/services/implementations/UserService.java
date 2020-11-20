package com.analuciabolico.sgtccapi.v1.users.services.implementations;

import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.users.dtos.UserRequest;
import com.analuciabolico.sgtccapi.v1.users.model.User;
import com.analuciabolico.sgtccapi.v1.users.repository.UserRepository;
import com.analuciabolico.sgtccapi.v1.users.services.interfaces.IUserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static sun.tools.jconsole.Resources.getMessage;

@Service
public class UserService implements IUserService {

    @Override
    public ResourceCreated save(UserRequest userRequest) {
        return new ResourceCreated(UserRepository.save(userRequest.convertToUser()));
    }

    @Override
    public User findByUsername(String username) {
        return UserRepository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<User> findAll(Sort sort) {
        return UserRepository.findAll(sort);
    }

}
