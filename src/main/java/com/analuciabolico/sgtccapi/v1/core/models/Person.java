package com.analuciabolico.sgtccapi.v1.core.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person implements Serializable {

    @NonNull
    @Column(length = 100, nullable = false, unique = true)
    protected String name;

    @NonNull
    @Column(length = 100, nullable = false, unique = true)
    protected String email;

    @NonNull
    @Column(length = 11, nullable = false, unique = true)
    protected String phone;

    @NonNull
    @Column(length = 50, nullable = false, unique = true)
    protected String registration;

    @NonNull
    @Column(length = 11, nullable = false, unique = true)
    protected String cpf;

    @NonNull
    @Column(nullable = false, columnDefinition = "timestamp")
    protected LocalDateTime createdAt;
}
