package com.analuciabolico.sgtccapi.v1.api.interest_areas;

import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.interest_areas.dtos.Interest_AreaRequest;
import com.analuciabolico.sgtccapi.v1.interest_areas.model.Interest_Area;
import com.analuciabolico.sgtccapi.v1.interest_areas.services.interfaces.IInterest_AreaService;
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
    private final IInterest_AreaService interestAreaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Interest_Area>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Interest_Area> list = interestAreaService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Interest_Area> findById(@PathVariable Long id) {
        return new ResponseEntity<>(interestAreaService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody Interest_AreaRequest interest_AreaRequest) {
        return new ResponseEntity<>(interestAreaService.save(interest_AreaRequest), HttpStatus.CREATED);
    }
}
