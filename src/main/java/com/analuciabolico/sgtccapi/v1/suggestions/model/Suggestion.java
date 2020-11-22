package com.analuciabolico.sgtccapi.v1.suggestions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.time.LocalDateTime;

import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "TEACHERS")
@SequenceGenerator(name = "SEQ_TEACHERS", sequenceName = "SEQUENCE_TEACHERS", allocationSize = 1)
public class Suggestion {

    @Builder
    public Suggestion(Long id, @NonNull String description, @NonNull String title, boolean search,
                      @NonNull LocalDateTime createdAt, @NonNull Teacher teacher) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.search = search;
        this.createdAt = createdAt;
        this.teacher = teacher;
    }

    @Id
    @GeneratedValue(generator = "SEQ_TEACHERS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String description;

    @NonNull
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean search;

    @NonNull
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime createdAt;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "FK_TEACHER_UID")
    private Teacher teacher;
}