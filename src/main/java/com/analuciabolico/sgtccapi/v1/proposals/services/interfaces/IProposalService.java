package com.analuciabolico.sgtccapi.v1.proposals.services.interfaces;

import java.util.List;
import org.springframework.data.domain.Sort;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.proposals.dtos.ProposalRequest;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;

public interface IProposalService {

    ResourceCreated save(ProposalRequest proposalRequest);

    Proposal findById(Long id);

    List<Proposal> findAll(Sort sort);
}
