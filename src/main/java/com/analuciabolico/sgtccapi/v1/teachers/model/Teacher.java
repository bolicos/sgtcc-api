package com.analuciabolico.sgtccapi.v1.teachers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TEACHERS")
@SequenceGenerator(name = "SEQ_TEACHERS", sequenceName = "SEQUENCE_TEACHERS", allocationSize = 1)
public class Teacher {

    @Builder
    public Teacher(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "SEQ_TEACHERS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "leader")
    private Set<Proposal> proposals;
}
