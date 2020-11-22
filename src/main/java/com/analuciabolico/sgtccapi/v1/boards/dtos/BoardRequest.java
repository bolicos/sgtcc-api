package com.analuciabolico.sgtccapi.v1.boards.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.analuciabolico.sgtccapi.v1.boards.model.Board;
import com.analuciabolico.sgtccapi.v1.classes.model.Class;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest implements Serializable {
    private Teacher leader;
    private Class aClass;
    private Proposal proposal;
    private LocalDateTime date;


    public Board convertToBoard() {
        return  Board.builder()
                .id(null).leader(this.leader).aClass(this.aClass).proposal(this.proposal).dateScheduled(this.date)
                .createdAt(LocalDateTime.now()).build();
    }
}
