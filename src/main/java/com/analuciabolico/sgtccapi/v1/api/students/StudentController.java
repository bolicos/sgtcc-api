package com.analuciabolico.sgtccapi.v1.api.students;

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
import com.analuciabolico.sgtccapi.v1.students.dtos.StudentRequest;
import com.analuciabolico.sgtccapi.v1.students.model.Student;
import com.analuciabolico.sgtccapi.v1.students.services.interfaces.IStudentService;
import com.analuciabolico.sgtccapi.v1.students.dtos.StudentProposalTitleResponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final IStudentService studentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAll(@RequestParam(required = false, defaultValue = "ASC") String sort) {
        List<Student> list = studentService.findAll(Sort.by(Sort.Direction.fromString(sort), "name"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceCreated> save(@RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.save(studentRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}/proposal_title", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentProposalTitleResponse> findTitleProposalByStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findTitleProposalByStudent(id), HttpStatus.OK);
    }
}
