package com.analuciabolico.sgtccapi.v1.proposals.services.implementations;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.proposals.dtos.ProposalRequest;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;
import com.analuciabolico.sgtccapi.v1.proposals.repository.ProposalRepository;
import com.analuciabolico.sgtccapi.v1.proposals.services.interfaces.IProposalService;

import lombok.AllArgsConstructor;

import static com.analuciabolico.sgtccapi.v1.core.validations.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.analuciabolico.sgtccapi.v1.core.validations.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class ProposalService implements IProposalService {

    private final ProposalRepository proposalRepository;

    @Override
    public ResourceCreated save(ProposalRequest proposalRequest) {
        return new ResourceCreated(proposalRepository.save(proposalRequest.convertToProposal()).getId());
    }

    @Override
    public Proposal findById(Long id) {
        return proposalRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Proposal> findAll(Sort sort) {
        return proposalRepository.findAll(sort);
    }
}
