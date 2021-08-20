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

// aduciona as anotatios de rest e de construtor com todos os argumentos
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/proposals")
public class ProposalController {
    private final IProposalService proposalService;
    // rota para listar as propostas
    // retorna no formato de json
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // cria um metodo de response entity com uma lista de propostas, que pode receber uma ordenação
    public ResponseEntity<List<Proposal>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        // instancia uma variavel lista que faz um find all na ordenacao recebida para o campo de titulo
        List<Proposal> list = proposalService.findAll(Sort.by(Sort.Direction.fromString(sort), "title"));
        // retorna uma response com a lista de propostas e o status 200
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proposal> findById(@PathVariable Long id) {
        return new ResponseEntity<>(proposalService.findById(id), HttpStatus.OK);
    }
    // rota para criar uma proposta
    // recebe o formato json
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    // cria um metodo de response entity de save que recebe os dados da proposta
    public ResponseEntity<ResourceCreated> save(@RequestBody ProposalRequest titleRequest) {
        // retorna o id da proposta criada e o status 201
        return new ResponseEntity<>(proposalService.save(titleRequest), HttpStatus.CREATED);
    }
}
