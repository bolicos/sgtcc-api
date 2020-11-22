package com.analuciabolico.sgtccapi.v1.examinations.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.analuciabolico.sgtccapi.v1.examinations.enums.ExaminationTypeEnum;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;

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
@Table(name = "EXAMINATIONS")
@SequenceGenerator(name = "SEQ_EXAMINATIONS", sequenceName = "SEQUENCE_EXAMINATIONS", allocationSize = 1)
public class Examination implements Serializable {

    @Builder
    public Examination(Long id, @NonNull String presentation, @NonNull boolean approved, @NonNull String textContent,
                       @NonNull String textStructure, @NonNull String language, String observation,
                       @NonNull String relevance, @NonNull String title, @NonNull Double note, ExaminationTypeEnum type,
                       @NonNull LocalDateTime createdAt, @NonNull Proposal proposal, @NonNull Teacher teacher) {
        this.id = id;
        this.presentation = presentation;
        this.approved = approved;
        this.textContent = textContent;
        this.textStructure = textStructure;
        this.language = language;
        this.observation = observation;
        this.relevance = relevance;
        this.title = title;
        this.note = note;
        this.type = type;
        this.createdAt = createdAt;
        this.proposal = proposal;
        this.teacher = teacher;
    }

    @Id
    @GeneratedValue(generator = "SEQ_EXAMINATIONS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String presentation;

    @NonNull
    @Column(nullable = false)
    private boolean approved;

    @NonNull
    @Column(nullable = false)
    private String textContent;

    @NonNull
    @Column(nullable = false)
    private String textStructure;

    @NonNull
    @Column(nullable = false)
    private String language;

    private String observation;

    @NonNull
    @Column(nullable = false)
    private String relevance;

    @NonNull
    @Column(nullable = false)
    private String title;

    @NonNull
    @Column(nullable = false, precision = 4, scale = 2)
    private Double note;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExaminationTypeEnum type;

    @NonNull
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime createdAt;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "FK_PROPOSAL_UID")
    private Proposal proposal;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "FK_TEACHER_UID")
    private Teacher teacher;
}
