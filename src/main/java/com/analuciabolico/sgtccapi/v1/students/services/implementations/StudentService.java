package com.analuciabolico.sgtccapi.v1.students.services.implementations;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

import io.micrometer.core.lang.NonNull;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.students.dtos.StudentRequest;
import com.analuciabolico.sgtccapi.v1.students.model.Student;
import com.analuciabolico.sgtccapi.v1.students.repository.StudentRepository;
import com.analuciabolico.sgtccapi.v1.students.services.interfaces.IStudentService;

import lombok.AllArgsConstructor;

import static com.analuciabolico.sgtccapi.v1.core.validations.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.analuciabolico.sgtccapi.v1.core.validations.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
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

    public String findTitleProposalByStudent(Long id) {
        return studentRepository.findTitleProposalByStudent(id);
    }

}
