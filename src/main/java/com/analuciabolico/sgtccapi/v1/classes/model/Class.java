package com.analuciabolico.sgtccapi.v1.classes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CLASSES")
@SequenceGenerator(name = "SEQUENCE_ALUNOS", allocationSize = 1)
public class Class {

    @Id
    @GeneratedValue(generator = "SEQUENCE_ALUNOS", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
}
