package com.analuciabolico.sgtccapi.v1.suggestions.dtos;

import java.time.LocalDateTime;

import com.analuciabolico.sgtccapi.v1.suggestions.model.Suggestion;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuggestionRequest {
    private String title;
    private String description;
    private boolean search;
    private Long teacher;

    public Suggestion convertToSuggestion() {
        return  Suggestion.builder()
                .id(null).title(this.title).description(this.description).search(this.search)
                .createdAt(LocalDateTime.now()).teacher(Teacher.builder().id(this.teacher).build()).build();
    }
}
