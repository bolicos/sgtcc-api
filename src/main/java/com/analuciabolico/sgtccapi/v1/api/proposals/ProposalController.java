package com.analuciabolico.sgtccapi.v1.api.proposals;

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
import com.analuciabolico.sgtccapi.v1.proposals.dtos.ProposalRequest;
import com.analuciabolico.sgtccapi.v1.proposals.model.Proposal;
import com.analuciabolico.sgtccapi.v1.proposals.services.interfaces.IProposalService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/proposals")
public class ProposalController {
    private final IProposalService proposalService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Proposal>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Proposal> list = proposalService.findAll(Sort.by(Sort.Direction.fromString(sort), "title"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proposal> findById(@PathVariable Long id) {
        return new ResponseEntity<>(proposalService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody ProposalRequest titleRequest) {
        return new ResponseEntity<>(proposalService.save(titleRequest), HttpStatus.CREATED);
    }
}
