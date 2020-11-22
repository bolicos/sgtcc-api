package com.analuciabolico.sgtccapi.v1.api.teachers;

import java.util.List;

import com.analuciabolico.sgtccapi.v1.teachers.repository.TeacherRepository;
import com.analuciabolico.sgtccapi.v1.titles.model.Title;
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
import com.analuciabolico.sgtccapi.v1.teachers.dtos.TeacherRequest;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;
import com.analuciabolico.sgtccapi.v1.teachers.services.interfaces.ITeacherService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    private final ITeacherService teacherService;
    private final TeacherRepository teacherRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Teacher>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Teacher> list = teacherService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> findById(@PathVariable Long id) {
        return new ResponseEntity<>(teacherService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody TeacherRequest teacherRequest) {
        return new ResponseEntity<>(teacherService.save(teacherRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}/titles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Title> findTitleByTeacher(@PathVariable Long id) {
        return new ResponseEntity<>(teacherRepository.findTitleByTeacher(id), HttpStatus.OK);
    }
}
