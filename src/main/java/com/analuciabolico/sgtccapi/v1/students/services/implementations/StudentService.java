package com.analuciabolico.sgtccapi.v1.students.services.implementations;

import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.students.dtos.StudentRequest;
import com.analuciabolico.sgtccapi.v1.students.model.Student;
import com.analuciabolico.sgtccapi.v1.students.repository.StudentRepository;
import com.analuciabolico.sgtccapi.v1.students.services.interfaces.IStudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    @Override
    public ResourceCreated save(StudentRequest studentRequest) {
        return new ResourceCreated(studentRepository.save(studentRequest.convertToStudent()).getId());
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Student> findAll(Sort sort) {
        return studentRepository.findAll(sort);
    }

}
