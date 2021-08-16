package com.analuciabolico.sgtccapi.v1.boards.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.analuciabolico.sgtccapi.v1.boards.model.Board;
import com.analuciabolico.sgtccapi.v1.classes.model.Class;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6699778121604398500L;
    private Long leader;
    private Long aClass;
    private Long proposal;
    private LocalDateTime date;


    public Board convertToBoard() {
        return  Board.builder()
                .id(null).leader(new Teacher(this.leader)).aClass(new Class(this.aClass))
                .proposal(new Proposal(this.proposal)).dateScheduled(this.date)
                .createdAt(LocalDateTime.now()).build();
    }
}
