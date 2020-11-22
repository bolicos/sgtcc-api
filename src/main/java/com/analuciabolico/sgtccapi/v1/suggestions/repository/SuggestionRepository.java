package com.analuciabolico.sgtccapi.v1.suggestions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.analuciabolico.sgtccapi.v1.suggestions.model.Suggestion;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

}
