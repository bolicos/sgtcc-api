package com.analuciabolico.sgtccapi.v1.users.dtos;

import com.analuciabolico.sgtccapi.v1.users.model.User;

import java.io.Serializable;

public class UserRequest  implements Serializable {
    private String username;
    private String password;

    public UserRequest(String username) {
        this.username = username;
    }

    public User convertToUser() {
        return new User(this.username, this.password);
    }

}
