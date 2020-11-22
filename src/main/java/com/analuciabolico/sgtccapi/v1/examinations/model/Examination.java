package com.analuciabolico.sgtccapi.v1.examinations.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EXAMINATIONS")
@SequenceGenerator(name = "SEQ_EXAMINATIONS", sequenceName = "SEQUENCE_EXAMINATIONS", allocationSize = 1)
public class Examination {

    @Id
    @GeneratedValue(generator = "SEQ_EXAMINATIONS", strategy = GenerationType.SEQUENCE)
    private Long id;

}
