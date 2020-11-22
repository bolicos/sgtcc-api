package com.analuciabolico.sgtccapi.v1.api.interest_areas;

import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.interest_areas.dtos.InterestAreaRequest;
import com.analuciabolico.sgtccapi.v1.interest_areas.model.InterestArea;
import com.analuciabolico.sgtccapi.v1.interest_areas.services.interfaces.IInterestAreaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/interest_areas")
public class InterestAreaController {
    private final IInterestAreaService interestAreaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InterestArea>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<InterestArea> list = interestAreaService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Interest_Area> findById(@PathVariable Long id) {
        return new ResponseEntity<>(interestAreaService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody InterestAreaRequest interestAreaRequest) {
        return new ResponseEntity<>(interestAreaService.save(interest_AreaRequest), HttpStatus.CREATED);
    }
}
