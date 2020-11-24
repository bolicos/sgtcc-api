package com.analuciabolico.sgtccapi.v1.teachers.services.implementations;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.teachers.dtos.TeacherRequest;
import com.analuciabolico.sgtccapi.v1.teachers.dtos.TeacherTitleResponse;
import com.analuciabolico.sgtccapi.v1.teachers.model.Teacher;
import com.analuciabolico.sgtccapi.v1.teachers.repository.TeacherJdbcRepository;
import com.analuciabolico.sgtccapi.v1.teachers.repository.TeacherRepository;
import com.analuciabolico.sgtccapi.v1.teachers.services.interfaces.ITeacherService;

import lombok.AllArgsConstructor;

import static com.analuciabolico.sgtccapi.v1.core.validations.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.analuciabolico.sgtccapi.v1.core.validations.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class TeacherService implements ITeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherJdbcRepository teacherJdbcRepository;

    @Override
    public ResourceCreated save(TeacherRequest studentRequest) {
        return new ResourceCreated(teacherRepository.save(studentRequest.convertToTeacher()).getId());
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Teacher> findAll(Sort sort) {
        return teacherRepository.findAll(sort);
    }

    @Override
    public TeacherTitleResponse findTitleByTeacher(Long id) {
        return teacherJdbcRepository.findTitleByTeacher(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }
}
