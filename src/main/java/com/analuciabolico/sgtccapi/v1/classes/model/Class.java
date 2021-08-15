package com.analuciabolico.sgtccapi.v1.classes.model;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import com.analuciabolico.sgtccapi.v1.boards.model.Board;
import com.analuciabolico.sgtccapi.v1.semesters.model.Semester;
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
@Table(name = "CLASSES")
@SequenceGenerator(name = "SEQ_CLASSES", sequenceName = "SEQUENCE_CLASSES", allocationSize = 1)
public class Class implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5241792556612004655L;

    @Builder
    public Class(Long id, @NonNull String name, @NonNull Teacher teacher,
                 @NonNull Semester semester, @NonNull LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.semester = semester;
        this.createdAt = createdAt;
    }

    public Class(@NonNull Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "SEQ_CLASSES", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "FK_TEACHER_UID")
    private Teacher teacher;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "FK_SEMESTER_UID")
    private Semester semester;

    @JsonIgnore
    @OneToMany(mappedBy = "aClass")
    private Set<Board> boards;

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, columnDefinition = "timestamp")
    protected LocalDateTime createdAt;

    @ElementCollection
    @MapKeyColumn(name="FK_STUDENT_UID",nullable = false)
    @Column(name="average")
    @CollectionTable(name="CLASSES_STUDENTS", joinColumns = @JoinColumn(name = "FK_CLASS_UID", nullable = false))
    private Map<Long, Long> students;
}
