package com.analuciabolico.sgtccapi.v1.api.titles;

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
import com.analuciabolico.sgtccapi.v1.titles.dtos.TitleRequest;
import com.analuciabolico.sgtccapi.v1.titles.model.Title;
import com.analuciabolico.sgtccapi.v1.titles.services.interfaces.ITitleService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/titles")
public class TitleController {
    private final ITitleService titleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Title>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Title> list = titleService.findAll(Sort.by(Sort.Direction.fromString(sort), "nomenclature"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Title> findById(@PathVariable Long id) {
        return new ResponseEntity<>(titleService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody TitleRequest titleRequest) {
        //System.out.println("name: "+titleRequest.);
        return new ResponseEntity<>(titleService.save(titleRequest), HttpStatus.CREATED);
    }
}
