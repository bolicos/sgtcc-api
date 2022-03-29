package com.analuciabolico.sgtccapi.v1.api.classes;

import java.util.List;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
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
import com.analuciabolico.sgtccapi.v1.classes.dtos.ClassAverageRequest;
import com.analuciabolico.sgtccapi.v1.classes.dtos.ClassRequest;
import com.analuciabolico.sgtccapi.v1.classes.model.Class;
import com.analuciabolico.sgtccapi.v1.classes.services.interfaces.IClassService;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/classes")
public class ClassController {
    private final IClassService classService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Class>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Class> list = classService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Class> findById(@PathVariable Long id) {
        return new ResponseEntity<>(classService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody ClassRequest classRequest) {
        return new ResponseEntity<>(classService.save(classRequest), HttpStatus.CREATED);
    }
}
