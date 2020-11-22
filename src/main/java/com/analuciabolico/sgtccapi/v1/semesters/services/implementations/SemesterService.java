package com.analuciabolico.sgtccapi.v1.semesters.services.implementations;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.semesters.dtos.SemesterRequest;
import com.analuciabolico.sgtccapi.v1.semesters.model.Semester;
import com.analuciabolico.sgtccapi.v1.semesters.repository.SemesterRepository;
import com.analuciabolico.sgtccapi.v1.semesters.services.interfaces.ISemesterService;

import lombok.AllArgsConstructor;

import static com.analuciabolico.sgtccapi.v1.core.validations.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.analuciabolico.sgtccapi.v1.core.validations.MessageValidationProperties.getMessage;


@Service
@AllArgsConstructor
public class SemesterService implements ISemesterService {
    private final SemesterRepository semesterRepository;

    @Override
    public ResourceCreated save(SemesterRequest studentRequest) {
        return new ResourceCreated(semesterRepository.save(studentRequest.convertToSemester()).getId());
    }

    @Override
    public Semester findById(Long id) {
        return semesterRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Semester> findAll(Sort sort) {
        return semesterRepository.findAll(sort);
    }
}
