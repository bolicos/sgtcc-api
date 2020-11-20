package com.analuciabolico.sgtccapi.v1.api.users;

import com.analuciabolico.sgtccapi.v1.users.model.User;
import com.analuciabolico.sgtccapi.v1.users.services.implementations.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/users/{username}")
public class UserController implements Serializable {

    @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        return new ResponseEntity<>(UserService.findByUsername(username), HttpStatus.OK);
    }

}
