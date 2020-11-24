package com.analuciabolico.sgtccapi.v1.students.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import com.analuciabolico.sgtccapi.v1.core.models.Person;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "STUDENTS")
@SequenceGenerator(name = "SEQ_STUDENTS", sequenceName = "SEQUENCE_STUDENTS", allocationSize = 1)
public class Student extends Person implements Serializable {

    @Builder
    public Student(@NonNull String name, @NonNull String email, @NonNull String phone, @NonNull String registration,
                   @NonNull String cpf, @NonNull LocalDateTime createdAt, Long id, Set<Proposal> proposals) {
        super(name, email, phone, registration, cpf, createdAt);
        this.id = id;
        this.proposals = proposals;
    }

    public Student(@NonNull Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "SEQ_STUDENTS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "author")
    private Set<Proposal> proposals;


}
