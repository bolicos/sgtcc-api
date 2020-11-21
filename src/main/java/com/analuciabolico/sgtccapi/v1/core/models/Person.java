package com.analuciabolico.sgtccapi.v1.core.models;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {

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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    protected LocalDateTime createdAt;
}
