package com.analuciabolico.sgtccapi.v1.api.suggestions;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.suggestions.dtos.SuggestionRequest;
import com.analuciabolico.sgtccapi.v1.suggestions.model.Suggestion;
import com.analuciabolico.sgtccapi.v1.suggestions.services.interfaces.ISuggestionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/suggestion")
public class SuggestionController {
    private final ISuggestionService suggestionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Suggestion>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Suggestion> list = suggestionService.findAll(Sort.by(Sort.Direction.fromString(sort), "title"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Suggestion> findById(@PathVariable Long id) {
        return new ResponseEntity<>(suggestionService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody SuggestionRequest suggestionRequest) {
        return new ResponseEntity<>(suggestionService.save(suggestionRequest), HttpStatus.CREATED);
    }
}
