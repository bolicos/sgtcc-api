package com.analuciabolico.sgtccapi.v1.students.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;
import com.analuciabolico.sgtccapi.v1.classes.model.Class;
import com.analuciabolico.sgtccapi.v1.core.models.Person;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ALUNOS")
@SequenceGenerator(name = "SEQUENCE_ALUNOS", allocationSize = 1)
public class Student extends Person {

    @Id
    @GeneratedValue(generator = "SEQUENCE_ALUNOS", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToMany(mappedBy = "autor")
    private List<Proposal> proposals;

    @OneToMany(mappedBy = "aluno")
    private List<Class> avaliacoes;

}
