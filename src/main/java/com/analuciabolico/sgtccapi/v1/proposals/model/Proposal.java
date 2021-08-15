package com.analuciabolico.sgtccapi.v1.proposals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import com.analuciabolico.sgtccapi.v1.boards.model.Board;
import com.analuciabolico.sgtccapi.v1.examinations.model.Examination;
import com.analuciabolico.sgtccapi.v1.students.model.Student;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "PROPOSALS")
@SequenceGenerator(name = "SEQ_PROPOSALS", sequenceName = "SEQUENCE_PROPOSALS", allocationSize = 1)
public class Proposal implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2865311345604874771L;

    @Builder
    public Proposal(Long id, @NonNull String title, @NonNull LocalDateTime createdAt, @NonNull Student author,
                    @NonNull Teacher leader) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.author = author;
        this.leader = leader;
    }

    public Proposal(@NonNull Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "SEQ_PROPOSALS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String title;

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, columnDefinition = "timestamp")
    protected LocalDateTime createdAt;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "FK_AUTHOR_UID")
    private Student author;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "FK_LEADER_UID")
    private Teacher leader;

    @JsonIgnore
    @OneToMany(mappedBy = "proposal")
    private Set<Board> boards;

    @JsonIgnore
    @OneToMany(mappedBy = "proposal")
    private Set<Examination> examinations;
}
