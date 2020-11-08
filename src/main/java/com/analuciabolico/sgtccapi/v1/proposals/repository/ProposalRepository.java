package com.analuciabolico.sgtccapi.v1.proposals.repository;

import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {

}
