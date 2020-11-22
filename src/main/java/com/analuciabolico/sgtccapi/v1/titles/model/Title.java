package com.analuciabolico.sgtccapi.v1.titles.model;

import com.analuciabolico.sgtccapi.v1.classes.model.Class;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;
import lombok.Builder;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TITLES")
@SequenceGenerator(name = "SEQ_TITLES", sequenceName = "SEQUENCE_TITLES", allocationSize = 1)
public class Title implements Serializable {

    @Builder()
    public Title(@NonNull String description, @NonNull String nomenclature, @NonNull String type, @NonNull Long id) {
        this.description;
        this.nomenclature;
        this.type;
        this.id;
    }

    @Id
    @NonNull
    @GeneratedValue(generator = "SEQ_TITLES", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false, length = 200)
    private String description;

    @Column(name = "NOMENCLATURE", nullable = false, length = 200)
    private String nomenclature;

    @Column(name = "TYPE", nullable = false, length = 200)
    private String type;

    @OneToMany(mappedBy = "fk_title_uid")
    private List<Teacher> teachers;

    public Long getId() {
        return id;
    }
}
