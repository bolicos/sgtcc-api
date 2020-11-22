package com.analuciabolico.sgtccapi.v1.api.titles;

import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.titles.dtos.TitleRequest;
import com.analuciabolico.sgtccapi.v1.titles.model.Title;
import com.analuciabolico.sgtccapi.v1.titles.services.interfaces.ITitleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/titles")
public class TitleController implements Serializable {
    private final ITitleService titleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Title>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Title> list = titleService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Title> findById(@PathVariable Long id) {
        return new ResponseEntity<>(titleService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody TitleRequest titleRequest) {
        return new ResponseEntity<>(titleService.save(titleRequest), HttpStatus.CREATED);
    }
}
