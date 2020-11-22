package com.analuciabolico.sgtccapi.v1.teachers.model;

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
import java.util.Set;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;
import com.analuciabolico.sgtccapi.v1.titles.model.Title;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "TEACHERS")
@SequenceGenerator(name = "SEQ_TEACHERS", sequenceName = "SEQUENCE_TEACHERS", allocationSize = 1)
public class Teacher implements Serializable {

    @Builder
    public Teacher(Long id, Set<Proposal> proposals, Title title) {
        this.id = id;
        this.proposals = proposals;
        this.title = title;
    }

    @Id
    @GeneratedValue(generator = "SEQ_TEACHERS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "leader")
    private Set<Proposal> proposals;

    @ManyToOne
    @JoinColumn(name = "FK_TITLE_UID")
    private Title title;
}
