package com.analuciabolico.sgtccapi.v1.api.semesters;

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
import com.analuciabolico.sgtccapi.v1.semesters.dtos.SemesterRequest;
import com.analuciabolico.sgtccapi.v1.semesters.model.Semester;
import com.analuciabolico.sgtccapi.v1.semesters.services.interfaces.ISemesterService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/semesters")
public class SemesterController {
    private final ISemesterService semesterService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Semester>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Semester> list = semesterService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Semester> findById(@PathVariable Long id) {
        return new ResponseEntity<>(semesterService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody SemesterRequest semesterRequest) {
        return new ResponseEntity<>(semesterService.save(semesterRequest), HttpStatus.CREATED);
    }
}
