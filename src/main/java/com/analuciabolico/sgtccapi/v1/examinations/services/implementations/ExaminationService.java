package com.analuciabolico.sgtccapi.v1.examinations.services.implementations;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.analuciabolico.sgtccapi.v1.core.models.ResourceCreated;
import com.analuciabolico.sgtccapi.v1.examinations.dtos.ExaminationRequest;
import com.analuciabolico.sgtccapi.v1.examinations.model.Examination;
import com.analuciabolico.sgtccapi.v1.examinations.repository.ExaminationRepository;
import com.analuciabolico.sgtccapi.v1.examinations.services.interfaces.IExaminationService;

import lombok.AllArgsConstructor;

import static com.analuciabolico.sgtccapi.v1.core.validations.GenericMessagesValidationEnum.ENTITY_NOT_FOUND;
import static com.analuciabolico.sgtccapi.v1.core.validations.MessageValidationProperties.getMessage;

@Service
@AllArgsConstructor
public class ExaminationService implements IExaminationService {

    private final ExaminationRepository examinationRepository;

    @Override
    public ResourceCreated save(ExaminationRequest examinationRequest) {
        return new ResourceCreated(examinationRepository.save(examinationRequest.convertToExamination()).getId());
    }

    @Override
    public Examination findById(Long id) {
        return examinationRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(getMessage(ENTITY_NOT_FOUND)));
    }

    @Override
    public List<Examination> findAll(Sort sort) {
        return examinationRepository.findAll(sort);
    }
}
