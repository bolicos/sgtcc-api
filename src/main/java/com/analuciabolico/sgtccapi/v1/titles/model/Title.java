package com.analuciabolico.sgtccapi.v1.titles.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.io.Serializable;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TITLES")
@SequenceGenerator(name = "SEQ_TITLES", sequenceName = "SEQUENCE_TITLES", allocationSize = 1)
public class Title implements Serializable {

    @Builder
    public Title(@NonNull String description, @NonNull String nomenclature, @NonNull String type, Long id) {
        this.description = description;
        this.nomenclature = nomenclature;
        this.type = type;
        this.id = id;
    }

    public Title(@NonNull Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "SEQ_TITLES", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false, length = 200)
    private String description;

    @Column(name = "NOMENCLATURE", nullable = false, length = 200)
    private String nomenclature;

    @Column(name = "TYPE", nullable = false, length = 200)
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "title")
    private Set<Teacher> teachers;

}
