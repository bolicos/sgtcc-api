package com.analuciabolico.sgtccapi.v1.users.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String username;

    private String password;
}
