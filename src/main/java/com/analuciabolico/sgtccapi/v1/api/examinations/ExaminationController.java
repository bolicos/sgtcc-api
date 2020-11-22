package com.analuciabolico.sgtccapi.v1.api.examinations;

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
import com.analuciabolico.sgtccapi.v1.examinations.dtos.ExaminationRequest;
import com.analuciabolico.sgtccapi.v1.examinations.model.Examination;
import com.analuciabolico.sgtccapi.v1.examinations.services.interfaces.IExaminationService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/examinations")
public class ExaminationController {
    private final IExaminationService examinationService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Examination>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Examination> list = examinationService.findAll(Sort.by(Sort.Direction.fromString(sort), "title"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Examination> findById(@PathVariable Long id) {
        return new ResponseEntity<>(examinationService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody ExaminationRequest examinationRequest) {
        return new ResponseEntity<>(examinationService.save(examinationRequest), HttpStatus.CREATED);
    }
}
