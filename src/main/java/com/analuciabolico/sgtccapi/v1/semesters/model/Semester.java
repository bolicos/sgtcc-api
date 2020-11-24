package com.analuciabolico.sgtccapi.v1.semesters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Set;
import com.analuciabolico.sgtccapi.v1.classes.model.Class;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "SEMESTERS")
@SequenceGenerator(name = "SEQ_SEMESTERS", sequenceName = "SEQUENCE_SEMESTERS", allocationSize = 1)
public class Semester implements Serializable {

    @Builder
    public Semester(Long id, String name, Set<Class> classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
    }

    public Semester(@NonNull Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "SEQ_SEMESTERS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 6)
    private String name;

    @OneToMany(mappedBy = "semester")
    private Set<Class> classes;
}
