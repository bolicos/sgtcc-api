package com.analuciabolico.sgtccapi.v1.titles.model;

import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "TITLES")
@SequenceGenerator(name = "SEQ_TITLES", sequenceName = "SEQUENCE_TITLES", allocationSize = 1)
public class Title implements Serializable {

    @Builder()
    public Title(@NonNull String description, @NonNull String nomenclature, @NonNull String type, @NonNull Long id) {
        this.description = description;
        this.nomenclature = nomenclature;
        this.type = type;
        this.id = id;
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

    @OneToMany(mappedBy = "FK_TITLE_UID")
    private Set<Teacher> teachers;

    public Long getId() {
        return id;
    }
}
