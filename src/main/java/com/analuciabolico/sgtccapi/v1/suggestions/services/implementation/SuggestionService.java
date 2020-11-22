package com.analuciabolico.sgtccapi.v1.suggestions.services.implementation;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.suggestions.dtos.SuggestionRequest;
import com.analuciabolico.sgtccapi.v1.suggestions.model.Suggestion;
import com.analuciabolico.sgtccapi.v1.suggestions.repository.SuggestionRepository;
import com.analuciabolico.sgtccapi.v1.suggestions.services.interfaces.ISuggestionService;

import lombok.AllArgsConstructor;

import static com.analuciabolico.sgtccapi.v1.core.validations.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.analuciabolico.sgtccapi.v1.core.validations.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class SuggestionService implements ISuggestionService {
    private final SuggestionRepository suggestionRepository;

    @Override
    public ResourceCreated save(SuggestionRequest studentRequest) {
        return new ResourceCreated(suggestionRepository.save(studentRequest.convertToSuggestion()).getId());
    }

    @Override
    public Suggestion findById(Long id) {
        return suggestionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Suggestion> findAll(Sort sort) {
        return suggestionRepository.findAll(sort);
    }
}
