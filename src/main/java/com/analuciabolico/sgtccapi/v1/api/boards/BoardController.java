package com.analuciabolico.sgtccapi.v1.api.boards;

import java.util.List;

import com.analuciabolico.sgtccapi.v1.boards.dtos.BoardRequest;
import com.analuciabolico.sgtccapi.v1.boards.model.Board;
import com.analuciabolico.sgtccapi.v1.boards.services.interfaces.IBoardService;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;

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

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardController {
    private final IBoardService boardService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Board>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Board> list = boardService.findAll(Sort.by(Sort.Direction.fromString(sort), "dateScheduled"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Board> findById(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody BoardRequest boardRequest) {
        return new ResponseEntity<>(boardService.save(boardRequest), HttpStatus.CREATED);
    }
}
