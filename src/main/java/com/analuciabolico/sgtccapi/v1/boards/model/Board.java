package com.analuciabolico.sgtccapi.v1.boards.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BOARDS")
@SequenceGenerator(name = "SEQ_BOARDS", sequenceName = "SEQUENCE_BOARDS", allocationSize = 1)
public class Board {

    @Id
    @GeneratedValue(generator = "SEQ_BOARDS", strategy = GenerationType.SEQUENCE)
    private Long id;
}
