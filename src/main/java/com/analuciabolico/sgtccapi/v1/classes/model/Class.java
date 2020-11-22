package com.analuciabolico.sgtccapi.v1.classes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;
import com.analuciabolico.sgtccapi.v1.students.model.Student;

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
@SequenceGenerator(name = "SEQ_CLASSES", sequenceName = "SEQUENCE_CLASSES", allocationSize = 1)
public class Class {

    @Id
    @GeneratedValue(generator = "SEQ_CLASSES", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "classes")
    private Set<Student> students;
}
