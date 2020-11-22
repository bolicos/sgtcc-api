package com.analuciabolico.sgtccapi.v1.proposals.dtos;

import java.time.LocalDateTime;

import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProposalRequest {

    private String title;
    private Long author;
    private Long leader;


    public Proposal convertToProposal() {
        return  Proposal.builder()
                .id(null).title(this.title).author(this.author).leader(this.leader).createdAt(LocalDateTime.now())
                .build();
    }
}
