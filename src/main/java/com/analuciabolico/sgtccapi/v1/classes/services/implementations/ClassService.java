package com.analuciabolico.sgtccapi.v1.classes.services.implementations;

import javax.persistence.EntityNotFoundException;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.analuciabolico.sgtccapi.v1.classes.dtos.ClassRequest;
import com.analuciabolico.sgtccapi.v1.classes.dtos.StudentClassResponse;
import com.analuciabolico.sgtccapi.v1.classes.model.Class;
import com.analuciabolico.sgtccapi.v1.classes.repository.ClassJdbcRepository;
import com.analuciabolico.sgtccapi.v1.classes.repository.ClassRepository;
import com.analuciabolico.sgtccapi.v1.classes.services.interfaces.IClassService;
import com.analuciabolico.sgtccapi.v1.core.exceptions.models.BusinessException;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.core.services.interfaces.IGeneratedReportPdf;

import lombok.AllArgsConstructor;

import static com.analuciabolico.sgtccapi.v1.core.validations.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.analuciabolico.sgtccapi.v1.core.validations.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class ClassService implements IClassService {
    private final ClassRepository classRepository;
    private final ClassJdbcRepository classJdbcRepository;
    private final IGeneratedReportPdf generatedReportPdf;

    @Override
    public ResourceCreated save(ClassRequest classRequest) {
        return new ResourceCreated(classRepository.save(classRequest.convertToClass()).getId());
    }

    @Override
    public Class findById(Long id) {
        return classRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Class> findAll(Sort sort) {
        return classRepository.findAll(sort);
    }

    @Override
    public void calculateAverageStudent(Long id, Long idStudent) {
        classJdbcRepository.calculateAverageStudent(id, idStudent).orElseThrow(
                        () -> new BusinessException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public InputStreamResource getStudentsReportsByClass(Long id) {
        List<StudentClassResponse> list = classJdbcRepository.getStudentsReportsByClass(id);
        ByteArrayInputStream pdf = generatedReportPdf.tableClassesStudent(list);
        return new InputStreamResource(pdf);
    }


}
