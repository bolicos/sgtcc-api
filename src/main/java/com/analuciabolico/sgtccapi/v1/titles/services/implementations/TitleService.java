package com.analuciabolico.sgtccapi.v1.titles.services.implementations;

import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.titles.dtos.TitleRequest;
import com.analuciabolico.sgtccapi.v1.titles.model.Title;
import com.analuciabolico.sgtccapi.v1.titles.repository.TitleRepository;
import com.analuciabolico.sgtccapi.v1.titles.services.interfaces.ITitleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.analuciabolico.sgtccapi.v1.core.validations.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.analuciabolico.sgtccapi.v1.core.validations.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class TitleService implements ITitleService {
    private final TitleRepository titleRepository;

    @Override
    public ResourceCreated save(TitleRequest titleRequest) {
        return new ResourceCreated(titleRepository.save(titleRequest.convertToTitle()).getId());
    }

    @Override
    public Title findById(Long id) {
        return titleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Title> findAll(Sort sort) {
        return titleRepository.findAll(sort);
    }
}
