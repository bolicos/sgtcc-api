package com.analuciabolico.sgtccapi.v1.core.models;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class Person {

    @Column(nullable = false)
    protected String nome;

    @Column(length = 100, nullable = false)
    protected String email;

    @Column(length = 11, nullable = false)
    protected String telefone;

    @Column(length = 50, nullable = false, unique = true)
    protected String matricula;

    @Column(length = 11, nullable = false, unique = true)
    protected String cpf;
}
