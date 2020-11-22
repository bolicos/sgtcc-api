package com.analuciabolico.sgtccapi.v1.suggestions.services.interfaces;

import java.util.List;
import org.springframework.data.domain.Sort;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.suggestions.dtos.SuggestionRequest;
import com.analuciabolico.sgtccapi.v1.suggestions.model.Suggestion;

public interface ISuggestionService {
    ResourceCreated save(SuggestionRequest suggestionRequest);

    Suggestion findById(Long id);

    List<Suggestion> findAll(Sort sort);
}
