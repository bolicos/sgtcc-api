package com.analuciabolico.sgtccapi.v1.users.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Getter
@Setter
@Entity
@NoArgsConstructor

public class User implements Serializable {

    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 200)
    private String password;

}

