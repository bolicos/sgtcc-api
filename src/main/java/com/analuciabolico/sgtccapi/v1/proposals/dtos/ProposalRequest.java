package com.analuciabolico.sgtccapi.v1.proposals.dtos;

import java.time.LocalDateTime;

import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;
import com.analuciabolico.sgtccapi.v1.students.model.Student;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// adiciona getters, setters, construtors com e sem argumentos
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProposalRequest {

    // define as variaveis
    private String title;
    private Long author;
    private Long leader;

    // converte os parametros recebidos na request para os campos correspondentes do banco
    // retorna a proposta criada no banco
    public Proposal convertToProposal() {
        return  Proposal.builder()
                .id(null).title(this.title).author(new Student(this.author)).leader(new Teacher(this.leader))
                .createdAt(LocalDateTime.now()).build();
    }
}
