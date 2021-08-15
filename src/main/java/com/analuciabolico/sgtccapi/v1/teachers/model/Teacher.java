package com.analuciabolico.sgtccapi.v1.teachers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import com.analuciabolico.sgtccapi.v1.boards.model.Board;
import com.analuciabolico.sgtccapi.v1.classes.model.Class;
import com.analuciabolico.sgtccapi.v1.core.models.Person;
import com.analuciabolico.sgtccapi.v1.examinations.model.Examination;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;
import com.analuciabolico.sgtccapi.v1.suggestions.model.Suggestion;
import com.analuciabolico.sgtccapi.v1.titles.model.Title;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Teacher extends Person {

    @Builder
    public Teacher(@NonNull String name, @NonNull String email, @NonNull String phone, @NonNull String registration,
                   @NonNull String cpf, @NonNull LocalDateTime createdAt, Long id, Set<Proposal> proposals,
                   @NonNull Title title, Set<Class> classes, Set<Board> boards, Set<Board> evaluator,
                   Set<Examination> examinations, Set<Suggestion> suggestions) {
        super(name, email, phone, registration, cpf, createdAt);
        this.id = id;
        this.proposals = proposals;
        this.title = title;
        this.classes = classes;
        this.boards = boards;
        this.evaluator = evaluator;
        this.examinations = examinations;
        this.suggestions = suggestions;
    }

    public Teacher(@NonNull Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "SEQ_TEACHERS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "leader")
    private Set<Proposal> proposals;

    @ManyToOne
    @JoinColumn(name = "FK_TITLE_UID")
    private Title title;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Class> classes;

    @JsonIgnore
    @OneToMany(mappedBy = "leader")
    private Set<Board> boards;

    @JsonIgnore
    @ManyToMany(mappedBy = "evaluators")
    private Set<Board> evaluator;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Examination> examinations;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Suggestion> suggestions;
}
